package com.zxt.clinic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.Doctor;
import com.zxt.clinic.repository.DoctorRepository;
import com.zxt.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findByDoctorName(String name) {
        return (doctorRepository.findByName(name)==null||doctorRepository.findByName(name).isEmpty())?null:doctorRepository.findByName(name).get(0);
    }

    @Override
    public Doctor findByDoctorId(int id) {
        return doctorRepository.findOne(id);
    }

    @Override
    public Doctor verificationDoctor(String username, String password) {
        return doctorRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public boolean isexisted(String username) {
        List<Doctor> doctors = doctorRepository.findByName(username);
        if (doctors == null||doctors.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(JSONObject request) {
        String password = (String)request.get("password");
        String username = (String)request.get("username");
        String name = (String)request.get("name");
        String sex = (String)request.get("sex");
        String phoneNumber = (String)request.get("phoneNumber");
        String email = (String)request.get("email");
        if (password==null||username==null||name==null||sex==null||phoneNumber==null||email==null) {
            return false;
        }
        Doctor doctor = new Doctor(username, password, name, sex, phoneNumber, email);
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public boolean updateDoctorInformation(JSONObject request) {
        String password = (String)request.get("password");
        String username = (String)request.get("username");
        String name = (String)request.get("name");
        String sex = (String)request.get("sex");
        String phoneNumber = (String)request.get("phoneNumber");
        String email = (String)request.get("email");
        int doctorId = (int)request.get("doctorId");
        String introduction = (String)request.get("introduction");
        if (password==null||username==null||name==null||sex==null||phoneNumber==null||email==null||introduction==null||doctorId==0) {
            return false;
        }
        Doctor doctor = new Doctor(doctorId,username, password, name, sex, phoneNumber, email,introduction);
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public boolean save(Doctor doctor) {
        if (doctor==null){
            return false;
        }else {
            doctorRepository.save(doctor);
            return true;
        }
    }
}
