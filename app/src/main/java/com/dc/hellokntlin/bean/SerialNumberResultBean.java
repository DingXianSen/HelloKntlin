package com.dc.hellokntlin.bean;

import java.io.Serializable;

/**
 * Created by dingchao on 2017/9/21.
 */

public class SerialNumberResultBean implements Serializable {
    /**
     * orderSn : 201709210835309981
     * cardNum : 7110010995430713
     * ticketTypeCn : 2D影片(35.0)
     * num : 2
     * amount：总点数
     * supplier : asdf
     * dateCreated : 2017-09-21T00:35:30Z
     * statusCn：交易状态：
     */

    private String orderSn;
    private String cardNum;
    private String ticketTypeCn;
    private int num;
    private String supplier;
    private String dateCreated;

    private Double amount;
    private String statusCn;

    public String getStatusCn() {
        return statusCn;
    }

    public void setStatusCn(String statusCn) {
        this.statusCn = statusCn;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getTicketTypeCn() {
        return ticketTypeCn;
    }

    public void setTicketTypeCn(String ticketTypeCn) {
        this.ticketTypeCn = ticketTypeCn;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SerialNumberResultBean(String orderSn, String cardNum, String ticketTypeCn, int num, String supplier, String dateCreated, Double amount,String statusCn) {
        this.orderSn = orderSn;
        this.cardNum = cardNum;
        this.ticketTypeCn = ticketTypeCn;
        this.num = num;
        this.supplier = supplier;
        this.dateCreated = dateCreated;
        this.amount = amount;
        this.statusCn=statusCn;
    }

    public SerialNumberResultBean() {
    }
}
