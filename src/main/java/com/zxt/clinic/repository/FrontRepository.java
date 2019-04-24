package com.zxt.clinic.repository;

import com.zxt.clinic.entity.Front;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrontRepository extends JpaRepository<Front,Integer>{
    public Front findByUsernameAndPassword(String username,String password);
    public Front findByUsername(String username);
}
