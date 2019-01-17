package com.itheima.domain;

import java.util.Date;

public class Favorite {
    private String rid;
    private Date date;
    private String uid;

    private User user;

    @Override
    public String toString() {
        return "Favorite{" +
                "rid='" + rid + '\'' +
                ", date=" + date +
                ", uid='" + uid + '\'' +
                ", user=" + user +
                '}';
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
