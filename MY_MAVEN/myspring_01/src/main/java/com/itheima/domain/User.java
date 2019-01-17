package com.itheima.domain;

import java.util.Date;

public class User {

    private String username ;
    private String adress ;
    private String sex ;
    private Date birthday ;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", adress='" + adress + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User(String username, String adress, String sex, Date birthday) {
        this.username = username;
        this.adress = adress;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
