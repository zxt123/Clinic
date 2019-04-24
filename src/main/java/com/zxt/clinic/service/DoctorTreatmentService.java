package com.zxt.clinic.service;

import com.zxt.clinic.entity.Doctor;
import com.zxt.clinic.entity.Treatment;

import java.util.List;

public interface DoctorTreatmentService {
    public List<Doctor> findByTreatmentId(Integer treatmentId);
    public List<Treatment> findByDoctorId(Integer doctorId);
}
