package com.zxt.clinic.entity;

import javax.persistence.*;



@Entity
public class TimeTable {
    @Id
    @GeneratedValue
    private Integer id;

    private String date;

    private String time;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "DoctorTimeTable",joinColumns = {@JoinColumn(name = "timeTableId",referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(name = "doctorId",referencedColumnName = "Id")})
//    private Set<Doctor> doctors;

    public TimeTable() {

    }

    public TimeTable(String date, String time) {
        this.date = date;
        this.time = time;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

//    public Set<Doctor> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Set<Doctor> doctors) {
//        this.doctors = doctors;
//    }
}
