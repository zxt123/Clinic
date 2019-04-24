package com.zxt.clinic.service;

import com.zxt.clinic.entity.Front;

public interface FrontService {
    public Front verificationFront(String username, String password);
    public void save(Front front);
    public boolean isexisted(String username);
}
