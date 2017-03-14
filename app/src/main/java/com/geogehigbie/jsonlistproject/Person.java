package com.geogehigbie.jsonlistproject;

/**
 * Created by georgehigbie on 3/13/17.
 */

public class Person {

    private String name;
    private String mobile;
    private String company;
    private String homePhone;
    private String address;
    private String birthday;
    private String email;


    public Person(String address, String birthday, String company, String email, String homePhone, String mobile, String name) {
        this.address = address;
        this.birthday = birthday;
        this.company = company;
        this.email = email;
        this.homePhone = homePhone;
        this.mobile = mobile;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
