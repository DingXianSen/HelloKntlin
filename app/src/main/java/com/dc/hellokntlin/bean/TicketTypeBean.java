package com.dc.hellokntlin.bean;

import java.io.Serializable;

/**
 * Created by dingchao on 2017/9/19.
 */

public class TicketTypeBean implements Serializable {

    /**
     * id : 1
     * name : 2D
     * point : 35
     */

    private int id;
    private String name;
    private int point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public TicketTypeBean(int id, String name, int point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public TicketTypeBean() {
    }

}
