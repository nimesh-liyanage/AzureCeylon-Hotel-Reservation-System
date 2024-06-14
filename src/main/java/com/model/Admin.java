package com.model;

public class Admin extends User {
    private int aId;
    private String aName;

    public Admin(int aId, String aName, String firstName, String lastname, String email, String phoneNo, String pw) {
        super(firstName, lastname, email, phoneNo, pw);
        this.aId = aId;
        this.aName = aName;
    }

    public int getAId() {
        return aId;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }
}
