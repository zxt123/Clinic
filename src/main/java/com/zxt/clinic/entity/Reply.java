package com.zxt.clinic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Reply {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer leaveMessageId;
    private Integer userId;
    private Integer doctorId;
    private String content;
    private Date time;
    public Reply(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaveMessageId() {
        return leaveMessageId;
    }

    public void setLeaveMessageId(Integer leaveMessageId) {
        this.leaveMessageId = leaveMessageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
