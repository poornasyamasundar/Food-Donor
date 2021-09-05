
/*

This is a class whose instance stores the information of a receiver who currently wants supply of the food.
This class has the details like the address, phone number etc.
While receiving, if you want to change some of the details temporarily, then those details will be stored 
in the object of this class.
SO , to deal with all the cases where we need these details, it would be easier to deal with the object 
of this type

So, this class has only getters and setters to deal with the property variables.
*/

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
