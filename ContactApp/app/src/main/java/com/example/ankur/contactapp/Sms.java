package com.example.ankur.contactapp;

/**
 * Created by ankur on 10/2/17.
 */

public class Sms {
    String name, date, otp;
    int id;

    public Sms(String name, String date, String otp, int id) {
        this.name = name;
        this.date = date;
        this.otp = otp;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
