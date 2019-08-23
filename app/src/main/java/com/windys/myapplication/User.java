package com.windys.myapplication;

import java.io.Serializable;

public class User implements Serializable {

    // dOB is day of birth(ngay sinh)
    String name, phoneNumber , dOB , email , province;

    public User(String name, String phoneNumber, String dOB, String email, String province) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dOB = dOB;
        this.email = email;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
