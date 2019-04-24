package com.zxt.clinic.service;

import com.zxt.clinic.entity.Appointment;
import com.zxt.clinic.entity.Treatment;
import com.zxt.clinic.web.model.WorkTimeTable;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    public void save(Appointment appointment);
    public List<Appointment> findAppointmentOfSomeDay(Date date);
    public WorkTimeTable appointmentInformationOfSomeDay(List<Appointment> appointments, WorkTimeTable workTimeTable, Treatment treatment,int doctorId);
    public List<Appointment> findAppointmentOfSomeDoctor(Date date,Integer doctorId);
    public List<Appointment> findAppointmentOfSomeDaySQL(Date date);

}
