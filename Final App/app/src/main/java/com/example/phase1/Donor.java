package com.example.phase1;

/*
This class defines the Donor Objet all the references of donor in the app will be made as an object of this class
 */
public class Donor
{
    private String name;    //Name of the donor indivudual/Institute
    private boolean type;   // type of the donor true if the donor is an organization, false if the donor is an indivisual.
    private String phno;    //Phone number
    private String address; //Address
    private String email;   //Email address of the donor.
    private int noOfDonations;

    Donor()
    {
        name = "";
        type = false;
        phno = "0000000000";
        address = "";
    }

    /*
        All the Setter and getter functions.
     */

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhno() {
        return phno;
    }

    public boolean getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public int getNoOfDonations() {
        return noOfDonations;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoOfDonations(int noOfDonations) {
        this.noOfDonations = noOfDonations;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", noOfDonations=" + noOfDonations +
                '}';
    }
}
