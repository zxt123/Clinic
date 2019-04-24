package com.zxt.clinic.repository;

import com.zxt.clinic.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment,Integer>{
    public List<Treatment> findByName(String name);
}
