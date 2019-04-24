package com.zxt.clinic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zxt.clinic.entity.User;
import com.zxt.clinic.repository.UserRepository;
import com.zxt.clinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User verificationUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user!=null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public boolean isexisted(String username) {
        User user = userRepository.findByUsername(username);
        if (user==null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void register(JSONObject request) {
        String password = (String)request.get("password");
        String username = (String)request.get("username");
        String name = (String)request.get("name");
        String sex = (String)request.get("sex");
        String ageString = (String) request.get("age");
        Integer age = Integer.parseInt(ageString);
        String phoneNumber = (String)request.get("phoneNumber");
        String email = (String)request.get("email");
        User user = new User(name,username,password,sex,age,phoneNumber,email);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
