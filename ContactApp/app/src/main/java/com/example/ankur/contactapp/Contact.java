package com.example.ankur.contactapp;

import java.io.Serializable;

/**
 * Created by ankur on 9/2/17.
 */

public class Contact implements Serializable{
    private String firstName, lastName, combineName, phoneNo;

    public Contact(String firstName, String lastName, String combineName, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.combineName = combineName;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCombineName() {
        return combineName;
    }

    public void setCombineName(String combineName) {
        this.combineName = combineName;
    }
}
