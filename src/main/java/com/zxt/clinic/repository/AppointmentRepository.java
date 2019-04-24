package com.zxt.clinic.repository;

import com.zxt.clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{
    public List<Appointment> findByAppointmentTimeBetween(Date date1,Date date2);
}
