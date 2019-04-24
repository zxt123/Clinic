package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.Doctor;
import com.zxt.clinic.entity.DoctorTreatment;
import com.zxt.clinic.entity.Treatment;
import com.zxt.clinic.repository.DoctorRepository;
import com.zxt.clinic.repository.DoctorTreatmentRepository;
import com.zxt.clinic.repository.TreatmentRepository;
import com.zxt.clinic.service.DoctorTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorTreatmentServiceImpl implements DoctorTreatmentService {
    @Autowired
    private DoctorTreatmentRepository doctorTreatmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Override
    public List<Doctor> findByTreatmentId(Integer treatmentId) {
        List<DoctorTreatment> doctorTreatments = doctorTreatmentRepository.findByTreatmentId(treatmentId);
        if (doctorTreatments==null||doctorTreatments.isEmpty()) {
            return null;
        }
        List<Doctor> doctors = new ArrayList<>();
        for (DoctorTreatment doctorTreatment:doctorTreatments){
            Doctor doctor = doctorRepository.findOne(doctorTreatment.getDoctorId());
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public List<Treatment> findByDoctorId(Integer doctorId) {
        List<DoctorTreatment> doctorTreatments = doctorTreatmentRepository.findByDoctorId(doctorId);
        if (doctorTreatments==null||doctorTreatments.isEmpty()) {
            return null;
        }
        List<Treatment> treatments = new ArrayList<>();
        for (DoctorTreatment doctorTreatment:doctorTreatments){
            Treatment treatment = treatmentRepository.findOne(doctorTreatment.getTreatmentId());
            treatments.add(treatment);
        }
        return treatments;
    }
}
