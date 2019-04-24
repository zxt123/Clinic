package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.Clinic;
import com.zxt.clinic.repository.ClinicRepository;
import com.zxt.clinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService{

    @Autowired
    private ClinicRepository clinicRepository;
    @Override
    public Clinic findById(Integer id) {
        return clinicRepository.findOne(id);
    }
}
