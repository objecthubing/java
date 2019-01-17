package com.itheima.domain;

public class Card {
    private String cno;
    private String bank;

    @Override
    public String toString() {
        return "Card{" +
                "cno='" + cno + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
