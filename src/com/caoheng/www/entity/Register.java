package com.caoheng.www.entity;

public class Register {
    private Integer id;
    private String username;
    private String userpassword;

    public Register() {
    }

    public Register(Integer id, String username, String userpassword) {
        this.id = id;
        this.username = username;
        this.userpassword = userpassword;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }


    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
