package com.zxt.clinic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;
    private String password;
    private String name;

    private String sex;

    private String phoneNumber;

    private String email;

    private int score;

    private String admissions;

    private String introduction;

    private String icon;

    public Doctor(){}

    public Doctor(int id,String username, String password, String name, String sex, String phoneNumber, String email,String introduction) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.introduction = introduction;
    }

    public Doctor(String username, String password, String name, String sex, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAdmissions() {
        return admissions;
    }

    public void setAdmissions(String admissions) {
        this.admissions = admissions;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

//    public Set<TimeTable> getTimeTables() {
//        return timeTables;
//    }
//
//    public void setTimeTables(Set<TimeTable> timeTables) {
//        this.timeTables = timeTables;
//    }
//
//    public Set<Treatment> getTreatments() {
//        return treatments;
//    }
//
//    public void setTreatments(Set<Treatment> treatments) {
//        this.treatments = treatments;
//    }
}
