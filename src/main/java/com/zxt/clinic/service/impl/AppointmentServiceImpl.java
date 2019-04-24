package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.Appointment;
import com.zxt.clinic.entity.Treatment;
import com.zxt.clinic.repository.AppointmentRepository;
import com.zxt.clinic.service.AppointmentService;
import com.zxt.clinic.utils.ComputeTool;
import com.zxt.clinic.web.model.WorkTimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAppointmentOfSomeDay(Date date) {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        if (appointmentList==null||appointmentList.isEmpty()) {
            return null;
        }
        List<Appointment> appointments = new ArrayList<>();
        for (Appointment appointment:appointmentList){
            if (ComputeTool.isSameDate(appointment.getAppointmentTime(),date)){
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    @Override
    public WorkTimeTable appointmentInformationOfSomeDay(List<Appointment> appointments, WorkTimeTable workTimeTable, Treatment treatment,int doctorId) {
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment appointment:appointments){
            if (appointment.getTreatmentId().equals(treatment.getId()) && appointment.getDoctorId().equals(doctorId) ){
                appointmentList.add(appointment);
            }
        }
        List<Integer> integers = new ArrayList<>();
        for (Appointment appointment:appointmentList){
            String date = new SimpleDateFormat("HH").format(appointment.getAppointmentTime());
            Integer integer = Integer.parseInt(date);
            integers.add(integer);
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(9,0);
        map.put(10,0);
        map.put(11,0);
        map.put(12,0);
        map.put(13,0);
        map.put(14,0);
        map.put(15,0);
        map.put(16,0);
        map.put(17,0);
        map.put(18,0);
        map.put(19,0);
        map.put(20,0);
        for (Integer integer:integers){
            int i = map.get(integer);
            map.put(integer,i+1);
        }
        System.out.println(map);
        if (map.get(9)>=treatment.getTimes()) {
            workTimeTable.set_9(true);
        }
        if (map.get(10)>=treatment.getTimes()) {
            workTimeTable.set_10(true);
        }
        if (map.get(11)>=treatment.getTimes()) {
            workTimeTable.set_11(true);
        }
        if (map.get(12)>=treatment.getTimes()) {
            workTimeTable.set_12(true);
        }
        if (map.get(13)>=treatment.getTimes()) {
            workTimeTable.set_13(true);
        }
        if (map.get(14)>=treatment.getTimes()) {
            workTimeTable.set_14(true);
        }
        if (map.get(15)>=treatment.getTimes()) {
            workTimeTable.set_15(true);
        }
        if (map.get(16)>=treatment.getTimes()) {
            workTimeTable.set_16(true);
        }
        if (map.get(17)>=treatment.getTimes()) {
            workTimeTable.set_17(true);
        }
        if (map.get(18)>=treatment.getTimes()) {
            workTimeTable.set_18(true);
        }
        if (map.get(19)>=treatment.getTimes()) {
            workTimeTable.set_19(true);
        }
        if (map.get(20)>=treatment.getTimes()) {
            workTimeTable.set_20(true);
        }
        return workTimeTable;
    }

    @Override
    public List<Appointment> findAppointmentOfSomeDoctor(Date date, Integer doctorId) {
        List<Appointment> appointments = findAppointmentOfSomeDay(date);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        for (Appointment appointment:appointments){
            if (appointment.getDoctorId().equals(doctorId)){
                appointmentList.add(appointment);
            }
        }
        if(appointmentList.isEmpty()){
            return null;
        }else {
            return appointmentList;
        }
    }

    @Override
    public List<Appointment> findAppointmentOfSomeDaySQL(Date date) {
        Date start = ComputeTool.convert2Zero(date);
        Date end = ComputeTool.convert2End(date);
        if (start==null||end==null){
            return null;
        }
        return appointmentRepository.findByAppointmentTimeBetween(start,end);
    }
}
