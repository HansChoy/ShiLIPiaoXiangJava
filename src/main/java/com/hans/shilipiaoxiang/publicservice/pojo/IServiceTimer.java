package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;
import java.util.Date;

public class IServiceTimer implements Serializable {
    private Integer id;

    private Integer servicelid;

    private Integer staffnum;

    private String adate;

    private Date updatetimer;

    private Double aindex;

    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServicelid() {
        return servicelid;
    }

    public void setServicelid(Integer servicelid) {
        this.servicelid = servicelid;
    }

    public Integer getStaffnum() {
        return staffnum;
    }

    public void setStaffnum(Integer staffnum) {
        this.staffnum = staffnum;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate == null ? null : adate.trim();
    }

    public Date getUpdatetimer() {
        return updatetimer;
    }

    public void setUpdatetimer(Date updatetimer) {
        this.updatetimer = updatetimer;
    }

    public Double getAindex() {
        return aindex;
    }

    public void setAindex(Double aindex) {
        this.aindex = aindex;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}