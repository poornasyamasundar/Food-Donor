package com.example.phase1;

public class Receive {
    private String name;
    private String phno;
    private String address;
    private String meals;

    Receive()
    {
        name = "";
        phno = "";
        address = "";
        meals = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    @Override
    public String toString()
    {
        return "Receiver{" +
                "name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                ", meals=" + meals +
                '}';
    }
}
