package com.zxt.clinic.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Treatment {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String price;
    private String introduction;
    private Integer times;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "DoctorTreatment",joinColumns = {@JoinColumn(name = "treatmentId",referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(name = "doctorId",referencedColumnName = "Id")})
//    private Set<Doctor> doctors2;

    public Treatment(){}

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
    //    public Set<Doctor> getDoctors2() {
//        return doctors2;
//    }
//
//    public void setDoctors2(Set<Doctor> doctors2) {
//        this.doctors2 = doctors2;
//    }
}
