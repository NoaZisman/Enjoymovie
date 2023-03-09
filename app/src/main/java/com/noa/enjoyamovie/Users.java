package com.noa.enjoyamovie;

public class Users {
    String name;
    String lastName;
    String gmail;
    String id;
    String password;
    public Users( String name,String lastName,String gmail,String id,String password)
    {
        this.name=name;
        this.lastName=lastName;
        this.gmail=gmail;
        this.id=id;
        this.password=password;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGmail() {
        return gmail;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "name:" + this.name + ", last name:" + lastName + ", gmail:" + this.gmail+ ", id:" + this.id+ ", password:" + this.password;
    }

}
