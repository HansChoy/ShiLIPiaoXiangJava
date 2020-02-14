package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class IPosition implements Serializable {
    private Integer id;

    private String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}