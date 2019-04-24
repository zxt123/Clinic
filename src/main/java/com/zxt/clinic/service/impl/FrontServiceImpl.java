package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.Front;
import com.zxt.clinic.repository.FrontRepository;
import com.zxt.clinic.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontServiceImpl implements FrontService {

    @Autowired
    private FrontRepository frontRepository;
    @Override
    public Front verificationFront(String username, String password) {
        return frontRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void save(Front front) {
        frontRepository.save(front);
    }

    @Override
    public boolean isexisted(String username) {
        Front front = frontRepository.findByUsername(username);
        if (front==null) {
            return false;
        } else {
            return true;
        }
    }
}
