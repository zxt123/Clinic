package com.zxt.clinic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer doctorId;
    private Integer treatmentId;
    private Date appointmentTime;
    private String questions;
    private Date time;
    public Appointment(){}

    public Appointment(Integer userId,String name, String email, String phoneNumber, Integer doctorId, Integer treatmentId, Date appointmentTime, String questions, Date time) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
        this.appointmentTime = appointmentTime;
        this.questions = questions;
        this.time = time;
    }
    public Appointment(String name, String email, String phoneNumber, Integer doctorId, Integer treatmentId, Date appointmentTime, String questions, Date time) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
        this.appointmentTime = appointmentTime;
        this.questions = questions;
        this.time = time;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }



    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
