package com.model;

public class Customer extends User {
  //  private int cid;   
    private String cName;

    public Customer( String cName, String firstname, String lastname, String email, String phoneNo, String pw) {
        super(firstname, lastname, email, phoneNo, pw);
      //  this.cid = cid;
        this.cName = cName;
    }

//    public int getCid() {
//        return cid;
//    }

    public String getCustomerName() {
        return cName;
    }

    public void setCustomerName(String cName) {
        this.cName = cName;
    }
}
