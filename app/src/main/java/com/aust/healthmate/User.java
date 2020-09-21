package com.aust.healthmate;

public class User {
    private String hospital;
    private String location;

    public User()
    {

    }

    public User(String hospital, String location) {
        this.hospital = hospital;
        this.location = location;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }




    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
