package com.example.phase1;

public class User
{
    private String name;
    private String phone;
    private String DoorNO;
    private String Area;
    private String email;
    private int Gender;
    private String userName;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhno(String phno) {
        phone = phno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getDoorNO() {
        return DoorNO;
    }

    public int getGender() {
        return Gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setDoorNO(String doorNO) {
        DoorNO = doorNO;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                ", DoorNO='" + DoorNO + '\'' +
                ", Area='" + Area + '\'' +
                ", email='" + email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
