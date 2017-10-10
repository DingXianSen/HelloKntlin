package com.dc.hellokntlin.bean;

/**
 * Created by dingchao on 2017/9/19.
 */

public class SignBean {
    private Integer userid;
    private Integer supplierid;

    public SignBean() {
    }

    public SignBean(Integer userid, Integer supplierid) {
        this.userid = userid;
        this.supplierid = supplierid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }
}
