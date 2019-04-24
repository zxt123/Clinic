package com.zxt.clinic.service;

import com.zxt.clinic.entity.Treatment;

import java.util.List;

public interface TreatmentService {
    public Treatment findByName(String name);
    public List<Treatment> findAllTreatment();
    public Treatment findById(int id);
}
