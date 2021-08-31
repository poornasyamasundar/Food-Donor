package com.example.phase1;

/*
This class defines the Donor Objet all the references of donor in the app will be made as an object of this class
 */
public class Donor
{
    private String name;    //Name of the donor individual/Institute
    private boolean type;   // type of the donor true if the donor is an organization, false if the donor is an indivisual.
    private String phno;    //Phone number
    private String address; //Address
    private float latitude; // Latitude of the location of the donor should be obtained from google maps
    private float longitude;    //longitude
    private String email;   //Email address of the donor.

    Donor()
    {
        name = "";
        type = false;
        phno = "0000000000";
        address = "";
        latitude = 0;
        longitude = 0;
    }

    /*
        All the Setter and getter functions.
     */
    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
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

    @Override
    public String toString() {
        return "Donor{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
