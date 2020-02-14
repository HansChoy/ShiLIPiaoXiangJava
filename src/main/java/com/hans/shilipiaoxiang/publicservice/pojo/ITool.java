package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class ITool implements Serializable {
    private Integer id;

    private String tname;

    private Integer detailtypeId;

    private Integer tcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getDetailtypeId() {
        return detailtypeId;
    }

    public void setDetailtypeId(Integer detailtypeId) {
        this.detailtypeId = detailtypeId;
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }
}