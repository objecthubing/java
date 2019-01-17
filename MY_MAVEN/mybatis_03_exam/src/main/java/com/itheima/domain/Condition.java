package com.itheima.domain;

public class Condition {
    private Integer cid ;

    private String rname ;

    private Double maxPrice ;  //最高价格

    private Double minPrice;    //最低价格

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "cid=" + cid +
                ", rname='" + rname + '\'' +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                '}';
    }
}
