package com.zxt.clinic.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.*;
import com.zxt.clinic.repository.LeadMessageRepository;
import com.zxt.clinic.repository.TreatmentRecordsRepository;
import com.zxt.clinic.service.*;
import com.zxt.clinic.utils.ComputeTool;
import com.zxt.clinic.web.model.AppResponse;
import com.zxt.clinic.web.model.SocketMessage;
import com.zxt.clinic.web.model.StatusMap;
import jdk.management.resource.internal.ApproverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private TreatmentRecordsService treatmentRecordsService;

    @Autowired
    private StatusTableService statusTableService;
    @Autowired
    private LeadMessageService leadMessageService;
    @RequestMapping(value = "login")
    public AppResponse login(@RequestBody JSONObject request){
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        Doctor doctor = doctorService.verificationDoctor(username,password);
        if (doctor==null){
            return AppResponse.failure(16);
        }else {
            return AppResponse.success().addParam(doctor);
        }
    }

    @RequestMapping(value = "register")
    public AppResponse register(@RequestBody JSONObject request){
        String username = (String) request.get("username");
        if (doctorService.isexisted(username)){
            return AppResponse.failure(16);
        }else {
            boolean b = doctorService.register(request);
            if (b) {
                return AppResponse.success();
            } else {
                return AppResponse.failure(16);
            }
        }
    }

    @RequestMapping(value = "appointmentInformation")
    public AppResponse appointmentInformation(@RequestBody JSONObject request){
        int doctorId = (int)request.get("doctorId");
        String dateS = (String)request.get("date");
        if (doctorId<=0||dateS==null){
            return AppResponse.failure(16);
        }
        Date date = ComputeTool.convertStr2Date(dateS);
        List<Appointment> appointments = appointmentService.findAppointmentOfSomeDoctor(date,doctorId);
        if (appointments == null||appointments.isEmpty()) {
            return AppResponse.success();
        }
        AppResponse appResponse = AppResponse.success();
        for (Appointment appointment:appointments){
            appResponse.addParam(appointment);
        }
        return appResponse;
    }

    @RequestMapping(value = "allTreatmentRecords")
    public AppResponse allTreatmentRecords(@RequestBody JSONObject request){
        int doctorId = (int)request.get("doctorId");
        List<TreatmentRecords> treatmentRecords = treatmentRecordsService.findAllTreatmentRecords(doctorId);
        if (treatmentRecords==null||treatmentRecords.isEmpty()){
            return AppResponse.success();
        }
        AppResponse appResponse = AppResponse.success();
        for (TreatmentRecords treatmentRecords1 :treatmentRecords){
            appResponse.addParam(treatmentRecords1);
        }
        return appResponse;
    }

    @RequestMapping(value = "treatmentRecordsOfSomeDay")
    public AppResponse treatmentRecordsOfSomeDay(@RequestBody JSONObject request){
        int doctorId =(int)request.get("doctorId");
        String dateS = (String)request.get("date");
        if (dateS==null||doctorId<=0){
            return AppResponse.failure(16);
        }
        Date date = ComputeTool.convertStr2Date(dateS);
        List<TreatmentRecords> treatmentRecords = treatmentRecordsService.findTreatmentRecordsOfSomeDay(doctorId,date);
        if (treatmentRecords==null||treatmentRecords.isEmpty()) {
            return AppResponse.success();
        }
        return AppResponse.success().addParam(treatmentRecords);
    }

    @RequestMapping(value = "information")
    public AppResponse information(@RequestBody JSONObject request){
        int doctorId = (int)request.get("doctorId");
        Doctor doctor = doctorService.findByDoctorId(doctorId);
        if (doctor == null) {
            return AppResponse.failure(16);
        } else {
            return AppResponse.success().addParam(doctor);
        }
    }

    @RequestMapping(value = "updateInformation")
    public AppResponse updateInformation(@RequestBody JSONObject request){
        if (doctorService.updateDoctorInformation(request)) {
            return AppResponse.success();
        } else {
            return AppResponse.failure(16);
        }
    }

    @RequestMapping(value = "waitingQueue")
    public AppResponse waitingQueue(@RequestBody JSONObject request){
        int doctorId = (int)request.get("doctorId");
        List<StatusTable> statusTables = statusTableService.findStatusTableOfDoctor(StatusMap.waiting,doctorId);
        if (statusTables==null||statusTables.isEmpty()){
            return AppResponse.success();
        }else {
            return AppResponse.success().addParam(statusTables);
        }
    }


    @MessageMapping("/send")
    @SendTo("/topic/send")
    public LeadMessage send(LeadMessage message) throws Exception {
        message.setTime(new Date());
        leadMessageService.save(message);
        return message;
    }

    @RequestMapping(value = "startTreat")
    public AppResponse startTreat(@RequestBody JSONObject request){
        int statusTableId = (int)request.get("statusTableId");
        String startTime = (String)request.get("startTime");
        Date start = ComputeTool.convertStr2Date(startTime);
        if (statusTableService.startTreat(statusTableId,start)){
            return AppResponse.success();
        }else {
            return AppResponse.failure(16);
        }
    }

    @RequestMapping(value = "endTreat")
    public AppResponse endTreat(@RequestBody JSONObject request){
        int statusTableId = (int)request.get("statusTableId");
        String endTime = (String)request.get("endTime");
        Date end = ComputeTool.convertStr2Date(endTime);
        if (statusTableService.endTreat(statusTableId,end)){
            return AppResponse.success();
        }else {
            return AppResponse.failure(16);
        }
    }
}
