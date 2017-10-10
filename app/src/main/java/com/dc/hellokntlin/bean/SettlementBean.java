package com.dc.hellokntlin.bean;

import java.io.Serializable;

/**
 * Created by dingchao on 2017/9/25.
 */

public class SettlementBean implements Serializable {

    public SettlementBean(int totalCount, Double totalAmount) {
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
    }

    public SettlementBean() {
    }

    /**
     * totalCount : 13
     * totalAmount : 455
     */


    private int totalCount;
    private Double totalAmount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
