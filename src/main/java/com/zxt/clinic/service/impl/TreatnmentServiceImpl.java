package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.Treatment;
import com.zxt.clinic.repository.TreatmentRepository;
import com.zxt.clinic.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatnmentServiceImpl implements TreatmentService{

    @Autowired
    private TreatmentRepository treatmentRepository;
    @Override
    public Treatment findByName(String name) {
        if (treatmentRepository.findByName(name)==null||treatmentRepository.findByName(name).isEmpty()) {
            return null;
        }
        return treatmentRepository.findByName(name).get(0);
    }

    @Override
    public List<Treatment> findAllTreatment() {
        return treatmentRepository.findAll();
    }

    @Override
    public Treatment findById(int id) {
        return treatmentRepository.findOne(id);
    }
}
