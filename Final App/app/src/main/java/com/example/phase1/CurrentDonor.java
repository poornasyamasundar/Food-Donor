
/*

This is a class whose instance stores the information of a donar who is currently willing to donate.
This class has the details like the address, phone number etc.
While donating, if you want to change some of the details temporarily, then those details will be stored 
in the object of this class.
SO , to deal with all the cases where we need these details, it would be easier to deal with the object 
of this type


*/

package com.example.phase1;

public class CurrentDonor
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

    public int getQuantity() {
        return quantity;
    }

    public String getLocality() {
        return locality;
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
