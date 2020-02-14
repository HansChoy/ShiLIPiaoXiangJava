package com.hans.shilipiaoxiang.publicservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ITimer implements Serializable {

    private Integer id;

    private Long timer;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer staffId;

    private IStaff iStaff;

    public IStaff getiStaff() {
        return iStaff;
    }

    public void setiStaff(IStaff iStaff) {
        this.iStaff = iStaff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ITimer{" +
                "id=" + id +
                ", timer=" + timer +
                ", updateTime=" + updateTime +
                ", staffId=" + staffId +
                ", iStaff=" + iStaff +
                '}';
    }

    public Long getTimer() {
        return timer;
    }

    public void setTimer(Long timer) {
        this.timer = timer;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}