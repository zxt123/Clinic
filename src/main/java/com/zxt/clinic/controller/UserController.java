package com.zxt.clinic.controller;


import com.alibaba.fastjson.JSONObject;

import com.zxt.clinic.entity.*;
import com.zxt.clinic.service.*;
import com.zxt.clinic.utils.ComputeTool;

import com.zxt.clinic.web.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private DoctorTreatmentService doctorTreatmentService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ClinicService clinicService;
    @RequestMapping(value = "/login")
    public AppResponse login(@RequestBody JSONObject request){
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        User user = userService.verificationUser(username,password);
        if (user==null){
            return AppResponse.failure(16);
        }else {
            return AppResponse.success();
        }
    }

    @RequestMapping(value = "register")
    public AppResponse register(@RequestBody JSONObject request){
        String username = (String) request.get("username");
        if (userService.isexisted(username)){
            return AppResponse.failure(16);
        }else {
            userService.register(request);
            return AppResponse.success();
        }
    }

    @RequestMapping(value = "appointment")
    public AppResponse appointment(@RequestBody JSONObject request){
        String username = (String)request.get("username");
        int doctorId = (int)request.get("doctorId");
        String treatmentName = (String) request.get("treatmentName");
        User user = userService.findByUsername(username);
        Doctor doctor = doctorService.findByDoctorId(doctorId);
        Treatment treatment = treatmentService.findByName(treatmentName);
         if (user == null || doctor==null||treatment==null){
            return  AppResponse.failure(16);
        }
        List<Treatment> treatmentList = doctorTreatmentService.findByDoctorId(doctor.getId());
        if (!treatmentList.contains(treatment)){
            return AppResponse.failure(17);
        }
        String sappointmentTime = (String)request.get("appointmentTime");
        Date appointmentTime = ComputeTool.convertStr2Date(sappointmentTime);
        String question = (String)request.get("question");
        String sTime = (String)request.get("time");
        Date time = ComputeTool.convertStr2Date(sTime);
        Appointment appointment = new Appointment(user.getId(),user.getName(),user.getEmail(),user.getPhoneNumber(),doctor.getId(),treatment.getId(),appointmentTime,question,time);
        appointmentService.save(appointment);
        return AppResponse.success().addParam(appointment);
    }

    @RequestMapping(value = "information")
    public AppResponse information(@RequestBody JSONObject request){
        String username = (String)request.get("username");
        User user = userService.findByUsername(username);
        if (user==null) {
            return AppResponse.failure(16);
        }
        return AppResponse.success().addParam(user);
    }

    @RequestMapping(value = "doctorList")
    public AppResponse doctorList(@RequestBody JSONObject request){
        String treatmentName = (String)request.get("treatmentName");
        Treatment treatment = treatmentService.findByName(treatmentName);
        if (treatment==null) {
            return AppResponse.failure(16);
        }
        List<Doctor> doctors = doctorTreatmentService.findByTreatmentId(treatment.getId());
        if (doctors==null||doctors.isEmpty()) {
            return AppResponse.success();
        }
        AppResponse appResponse = AppResponse.success();
        for (Doctor doctor:doctors){
            appResponse.addParam(doctor);
        }
        return appResponse;
    }

    @RequestMapping(value = "treatmentList")
    @CrossOrigin
    public AppResponse treatmentList(){
        List<Treatment> treatments = treatmentService.findAllTreatment();
        if (treatments==null||treatments.isEmpty()) {
            return AppResponse.failure(16);
        }
        return AppResponse.success().addParam(treatments);
    }

    @RequestMapping(value = "appointmentOfSomeDay")
    public AppResponse appointmentOfSomeDay(@RequestBody JSONObject request){
        String dateString =(String)request.get("date");
        Date date = ComputeTool.convertStr2Date(dateString);
        int week = (int)request.get("week");
        String treatmentName = (String)request.get("treatmentName");
        Treatment treatment = treatmentService.findByName(treatmentName);
        System.out.println(treatment.getId());
        int doctorId = (int)request.get("doctorId");
        WorkTimeTable workTimeTable =new WorkTimeTable();
        List<Appointment> appointments = appointmentService.findAppointmentOfSomeDay(date);
        if (appointments!=null&&!appointments.isEmpty()){
            workTimeTable = appointmentService.appointmentInformationOfSomeDay(appointments,workTimeTable,treatment,doctorId);
        }
        if (week == 6){
            return AppResponse.success().addParam(SaturdayTimeTable.convertTo(workTimeTable));
        }else if (week == 7){
            return AppResponse.success().addParam(SundayTimeTable.convertTo(workTimeTable));
        }else {
            return AppResponse.success().addParam(WorkDayTimeTable.convertTo(workTimeTable));
        }
    }

    @RequestMapping(value = "clinicInformation")
    public AppResponse clinicInformation(@RequestBody JSONObject request){
        int clinicId = (int)request.get("clinicId");
        Clinic clinic = clinicService.findById(clinicId);
        if (clinic==null) {
            return AppResponse.failure(16);
        }
        return AppResponse.success().addParam(clinic);
    }

}