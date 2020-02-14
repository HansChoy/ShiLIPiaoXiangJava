package com.hans.shilipiaoxiang.publicservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class IOrder implements Serializable {
    private Integer id;

    private Integer userId;
    private IUser user;

    private Integer useraddressId;
    private IUserDetail userDetail;

    private Integer detailtypeId;
    private IDetailtype detailtype;
   // private List<IStaff> staffs;

    private IStaff iStaff;
    private ITool iTool;
    private IToolrecord iToolrecord;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startTime;

    private Double price;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date orderTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date finalyTime;

    private Integer state;

    private String comm;


    public IStaff getiStaff() {
        return iStaff;
    }

    public void setiStaff(IStaff iStaff) {
        this.iStaff = iStaff;
    }

    public ITool getiTool() {
        return iTool;
    }

    public void setiTool(ITool iTool) {
        this.iTool = iTool;
    }

    public IToolrecord getiToolrecord() {
        return iToolrecord;
    }

    public void setiToolrecord(IToolrecord iToolrecord) {
        this.iToolrecord = iToolrecord;
    }

    public IUser getUser() {
        return user;
    }


//    public List<IStaff> getStaffs() {
//        return staffs;
//    }
//
//    public void setStaffs(List<IStaff> staffs) {
//        this.staffs = staffs;
//    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IUserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(IUserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public IDetailtype getDetailtype() {
        return detailtype;
    }

    public void setDetailtype(IDetailtype detailtype) {
        this.detailtype = detailtype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUseraddressId() {
        return useraddressId;
    }

    public void setUseraddressId(Integer useraddressId) {
        this.useraddressId = useraddressId;
    }

    public Integer getDetailtypeId() {
        return detailtypeId;
    }

    public void setDetailtypeId(Integer detailtypeId) {
        this.detailtypeId = detailtypeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getFinalyTime() {
        return finalyTime;
    }

    public void setFinalyTime(Date finalyTime) {
        this.finalyTime = finalyTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }


    @Override
    public String toString() {
        return "IOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", useraddressId=" + useraddressId +
                ", detailtypeId=" + detailtypeId +
                ", startTime=" + startTime +
                ", price=" + price +
                ", orderTime=" + orderTime +
                ", finalyTime=" + finalyTime +
                ", state=" + state +
                ", comm='" + comm + '\'' +
                '}';
    }
}