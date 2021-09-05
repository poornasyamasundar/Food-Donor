package com.example.phase1;

public class CurrentReceiver
{
    private String name;
    private String phno;
    private String address;
    private String email;
    private int quantity;
    private String locality;

    public String getName() {
        return name;
    }

    public String getPhno() {
        return phno;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getLocality() {
        return locality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "CurrentDonor{" +
                "name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
