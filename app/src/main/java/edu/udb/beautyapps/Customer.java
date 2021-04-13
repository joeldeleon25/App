package edu.udb.beautyapps;

import java.io.Serializable;

public class Customer implements Serializable {

    private String custName;
    private String custEmail;
    private int custPhone;
    private String custId;

    public Customer() {
    }

    public Customer(String custName, String custEmail, int custPhone, String custId) {
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public int getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(int custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
