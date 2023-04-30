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

    public Users() {
    }

    public String getUsername() { return username; }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
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
