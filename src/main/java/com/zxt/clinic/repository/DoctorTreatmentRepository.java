package com.zxt.clinic.repository;

import com.zxt.clinic.entity.DoctorTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorTreatmentRepository extends JpaRepository<DoctorTreatment,Integer>{
    public List<DoctorTreatment> findByDoctorId(Integer doctorId);
    public List<DoctorTreatment> findByTreatmentId(Integer treatmentId);
}
