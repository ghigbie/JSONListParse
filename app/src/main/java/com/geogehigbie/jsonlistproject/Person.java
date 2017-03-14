package com.geogehigbie.jsonlistproject;

/**
 * Created by georgehigbie on 3/13/17.
 */

public class Person {

    private String name;
    private String company;
    private String homePhone;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressZip;
    private String birthday;
    private String email;


    public Person(String addressCity, String addressState, String addressStreet, String addressZip,
                  String birthday, String company, String email, String homePhone, String name) {
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressStreet = addressStreet;
        this.addressZip = addressZip;
        this.birthday = birthday;
        this.company = company;
        this.email = email;
        this.homePhone = homePhone;
        this.name = name;
    }


    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public Person(String name, String homePhone) {
        this.name = name;
        this.homePhone = homePhone;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
