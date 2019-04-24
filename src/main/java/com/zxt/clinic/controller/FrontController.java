package com.zxt.clinic.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.*;
import com.zxt.clinic.service.*;
import com.zxt.clinic.service.impl.FrontServiceImpl;
import com.zxt.clinic.utils.ComputeTool;
import com.zxt.clinic.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "front")
public class FrontController {

    @Autowired
    private FrontService frontService;

    @Autowired
    private StatusTableService statusTableService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorTreatmentService doctorTreatmentService;
    @Autowired
    private TreatmentRecordsService treatmentRecordsService;
    @RequestMapping(value = "login")
    public AppResponse login(@RequestBody JSONObject request){
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        Front front = frontService.verificationFront(username,password);
        if (front==null){
            return AppResponse.failure(16);
        }else {
            return AppResponse.success();
        }
    }

    @RequestMapping(value = "register")
    public AppResponse register(@RequestBody JSONObject request){
        String username = (String)request.get("username");
        String password = (String)request.get("password");
        String name = (String)request.get("name");
        String phoneNumber = (String)request.get("phoneNumber");
        if (username==null||password==null||name==null||phoneNumber==null){
            return AppResponse.failure(16);
        }
        if (frontService.isexisted(username)){
            return AppResponse.failure(16);
        }
        Front front = new Front(username,password,name,phoneNumber);
        frontService.save(front);
        return AppResponse.success();
    }

    /*
    这一步比较关键，在执行查看每位客人的实时信息前都应该先执行这一步。
    首先，它清空statustable表中的所有数据记录，并将这些数据记录转换为disciplineRecord表中的数据。
    然后，他将查询今天的预约信息，并将这些信息返回。
    如果这些预约信息的id没有出现在statustable表、treatmentRecords表和disciplineRecord表中，则将他们转换成statusTable表中。
     */
    @RequestMapping(value = "appointmentOfToday")
    public AppResponse appointmentOfToday(){
        if (statusTableService.convert2DisciplineRecord()) {
            List<Appointment> appointments = statusTableService.convert2StatusTable();
            if (appointments==null||appointments.isEmpty()){
                return AppResponse.success();
            }
            return AppResponse.success().addParam(appointments);
        }else {
            return AppResponse.failure(16);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "appointmentOfSomeday")
    public AppResponse appointmentOfSomeDay(@RequestBody JSONObject request){
        String sdate = (String)request.get("date");
        Date date = ComputeTool.convertStr2Date(sdate);
        List<Appointment> appointments = appointmentService.findAppointmentOfSomeDaySQL(date);
        if (appointments==null||appointments.isEmpty()){
            return AppResponse.success();
        }
        return AppResponse.success().addParam(appointments);
    }

    @RequestMapping(value = "statusInformation")
    public AppResponse statusInformation(@RequestBody JSONObject request){
        int statusId = (int) request.get("statusId");
        List<StatusTable> statusTables = statusTableService.findStatusTable(statusId);
        if (statusTables==null||statusTables.isEmpty()){
            return AppResponse.success();
        }
        return AppResponse.success().addParam(statusTables);
    }

    @RequestMapping(value = "arrive")
    public AppResponse arrive(@RequestBody JSONObject request){
        int statusTableId = (int)request.get("statusTableId");
        StatusTable statusTable = statusTableService.findStatusTableById(statusTableId);
        if (statusTable==null){
            return AppResponse.failure(16);
        }
        statusTable.setStatusId(StatusMap.waiting);
        statusTableService.save(statusTable);
        return AppResponse.success();
    }

    @RequestMapping(value = "appointment")
    public AppResponse appointment(@RequestBody JSONObject request){
        String username = (String)request.get("username");
        int doctorId = (int)request.get("doctorId");
        String treatmentName = (String) request.get("treatmentName");
        String sappointmentTime = (String)request.get("appointmentTime");
        Date appointmentTime = ComputeTool.convertStr2Date(sappointmentTime);
        String question = (String)request.get("question");
        String sTime = (String)request.get("time");
        Date time = ComputeTool.convertStr2Date(sTime);
        String phoneNumber = (String)request.get("phoneNumber");
        String email = (String)request.get("email");
        Doctor doctor = doctorService.findByDoctorId(doctorId);
        Treatment treatment = treatmentService.findByName(treatmentName);
        if (username == null || doctor==null||treatment==null){
            return  AppResponse.failure(16);
        }
        List<Treatment> treatmentList = doctorTreatmentService.findByDoctorId(doctor.getId());
        if (!treatmentList.contains(treatment)){
            return AppResponse.failure(17);
        }
        Appointment appointment = new Appointment(username,email,phoneNumber,doctor.getId(),treatment.getId(),appointmentTime,question,time);
        appointmentService.save(appointment);
        return AppResponse.success().addParam(appointment);
    }

    @RequestMapping(value ="pay" )
    public AppResponse pay(@RequestBody JSONObject request){
        String payMethod = (String)request.get("payMethod");
        int statusTableId = (int)request.get("statusTableId");
        int score = (int)request.get("score");
        String comment = (String)request.get("comment");
        StatusTable statusTable = statusTableService.findStatusTableById(statusTableId);
        if (statusTable==null){
            return AppResponse.failure(16);
        }else {
            int doctorId = statusTable.getDoctorId();
            List<TreatmentRecords> treatmentRecords = treatmentRecordsService.findAllTreatmentRecords(doctorId);
            Doctor doctor = doctorService.findByDoctorId(doctorId);
            int reScore;
            if (treatmentRecords!=null&&!treatmentRecords.isEmpty()){
                reScore = (doctor.getScore()*treatmentRecords.size()+score)/(treatmentRecords.size()+1);
            }else {
                reScore = score;
            }
            doctor.setScore(reScore);
            if (doctorService.save(doctor)){
                statusTable.setScore(score);
                statusTable.setComment(comment);
                statusTable.setPayMethod(payMethod);
                if (statusTableService.endTreat(statusTable)) {
                    return AppResponse.success();
                } else {
                    return AppResponse.failure(16);
                }
             }else {
                return AppResponse.failure(17);
            }
        }

    }

}
