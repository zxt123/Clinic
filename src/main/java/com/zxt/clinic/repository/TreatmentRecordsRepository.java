package com.zxt.clinic.repository;

import com.zxt.clinic.entity.TreatmentRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRecordsRepository extends JpaRepository<TreatmentRecords,Integer>{
    public List<TreatmentRecords> findByDoctorId(int doctorId);
    public TreatmentRecords findByAppointmentId(Integer appointmentId);
}
