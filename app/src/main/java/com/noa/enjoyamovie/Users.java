package com.noa.enjoyamovie;

public class Users {
   protected String username;
   protected String id;
   protected String password;
    public Users( String name,String id,String password)
    {
        this.username=name;
        this.id=id;
        this.password=password;
    }
    public String getName() {
        return username;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.username = name;
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
        return "name:" + this.username + ", id:" + this.id+ ", password:" + this.password;
    }

}
