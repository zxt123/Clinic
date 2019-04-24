package com.zxt.clinic.service;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.Doctor;

import java.util.List;

public interface DoctorService {
    public Doctor findByDoctorName(String name);
    public Doctor findByDoctorId(int id);
    public Doctor verificationDoctor(String username,String password);
    public boolean isexisted(String username);
    public boolean register(JSONObject request);
    public boolean updateDoctorInformation(JSONObject request);
    public boolean save(Doctor doctor);
}
