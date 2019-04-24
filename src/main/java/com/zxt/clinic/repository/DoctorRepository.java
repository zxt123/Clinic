package com.zxt.clinic.repository;

import com.zxt.clinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
    public List<Doctor> findByName(String name);
    public Doctor findByUsernameAndPassword(String username ,String password);
}
