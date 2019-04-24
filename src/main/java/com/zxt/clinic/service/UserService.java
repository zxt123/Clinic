package com.zxt.clinic.service;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.User;

public interface UserService {
    public User verificationUser(String username,String password);
    public boolean isexisted(String username);
    public void register(JSONObject request);
    public User findByUsername(String username);
}
