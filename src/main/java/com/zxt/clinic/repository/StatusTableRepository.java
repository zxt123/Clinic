package com.zxt.clinic.repository;

import com.zxt.clinic.entity.StatusTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StatusTableRepository extends JpaRepository<StatusTable,Integer>{
    public List<StatusTable> findByStatusId(int statusId);
    public List<StatusTable> findByStatusIdAndDoctorId(int statusId,int doctorId);
    public List<StatusTable> findByAppointmentTimeBefore(Date date);
    public StatusTable findByAppointmentId(Integer appointmentId);
}
