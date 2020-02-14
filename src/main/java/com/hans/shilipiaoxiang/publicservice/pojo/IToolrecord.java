package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class IToolrecord implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer staffId;
    private String staffname;

    private Integer toolId;

    private Integer count;

    private Integer state;

    private ITool iTool;

    private IOrder iOrder;

    private IStaff staff;

    private IDetailtype iDetailtype;




    public IStaff getStaff() {
        return staff;
    }

    public void setStaff(IStaff staff) {
        this.staff = staff;
    }

    public IDetailtype getiDetailtype() {
        return iDetailtype;
    }

    public void setiDetailtype(IDetailtype iDetailtype) {
        this.iDetailtype = iDetailtype;
    }

    public IOrder getiOrder() {
        return iOrder;
    }

    public void setiOrder(IOrder iOrder) {
        this.iOrder = iOrder;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public ITool getiTool() {
        return iTool;
    }

    public void setiTool(ITool iTool) {
        this.iTool = iTool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}