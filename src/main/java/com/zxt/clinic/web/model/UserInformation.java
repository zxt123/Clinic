package com.zxt.clinic.web.model;

public class UserInformation {
    private Integer flag;
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String sex;
    private String icon;
    private Integer age;
    private String phoneNumber;
    private Integer favoriteDoctorId;
    private Integer deviceId;
    public UserInformation(){}

    public Integer getId() {
        return id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getFavoriteDoctorId() {
        return favoriteDoctorId;
    }

    public void setFavoriteDoctorId(Integer favoriteDoctorId) {
        this.favoriteDoctorId = favoriteDoctorId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
