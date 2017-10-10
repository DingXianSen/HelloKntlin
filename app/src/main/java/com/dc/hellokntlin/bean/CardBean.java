package com.dc.hellokntlin.bean;

import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by dingchao on 2017/9/19.
 */

/*卡Bean*/
public class CardBean implements Serializable {
    private Double points;//余额
    private String cardNo;//卡号
    private String cardValieTime;//是否过期

    public CardBean() {
    }

    public CardBean(Double points, String cardNo,String cardValieTime) {
        this.points = points;
        this.cardNo = cardNo;
        this.cardValieTime=cardValieTime;
    }

    protected CardBean(Parcel in) {
        cardNo = in.readString();
        cardValieTime = in.readString();
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardValieTime() {
        return cardValieTime;
    }

    public void setCardValieTime(String cardValieTime) {
        this.cardValieTime = cardValieTime;
    }


}