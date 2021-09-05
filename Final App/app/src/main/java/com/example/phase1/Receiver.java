package com.example.phase1;

/*
This class defines the Receiver Object all the references of Receiver in the app will be made as an object of this class
This class is same as the Donar class. So we simply extended the Donar class.
 */
public class Receiver extends Donor
{
@Override
    public String toString() {
        return "Receiver{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", phno='" + phno + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';

}
