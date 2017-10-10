package com.dc.hellokntlin.bean;

import java.io.Serializable;

/**
 * Created by dingchao on 2017/9/25.
 */

/*交易成功信息展示实体*/
public class SuccessBean implements Serializable {

    /**
     * orderSn : 20170925134243937
     * cardNum : 7110011220226770
     * ticketType : 2D
     * amount : 35
     * num : 1
     * supplierCn : juyougys
     */

    private String orderSn;
    private String cardNum;
    private String ticketType;
    private Double amount;
    private String num;
    private String supplierCn;

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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSupplierCn() {
        return supplierCn;
    }

    public void setSupplierCn(String supplierCn) {
        this.supplierCn = supplierCn;
    }

    public SuccessBean(String orderSn, String cardNum, String ticketType, Double amount, String num, String supplierCn) {
        this.orderSn = orderSn;
        this.cardNum = cardNum;
        this.ticketType = ticketType;
        this.amount = amount;
        this.num = num;
        this.supplierCn = supplierCn;
    }

    public SuccessBean() {
    }
}
