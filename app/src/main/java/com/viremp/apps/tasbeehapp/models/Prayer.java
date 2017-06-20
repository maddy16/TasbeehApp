package com.viremp.apps.tasbeehapp.models;

import java.io.Serializable;

/**
 * Created by Maddy on 20/06/2017.
 */

public class Prayer implements Serializable{
    private String name,detail,desc;
    int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
