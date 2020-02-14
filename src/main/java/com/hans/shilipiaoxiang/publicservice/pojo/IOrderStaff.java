package com.hans.shilipiaoxiang.publicservice.pojo;

public class IOrderStaff {
    private Integer id;

    private Integer orderId;

    private Integer staffId;

    private IStaff staffs;


    public IStaff getStaffs() {
        return staffs;
    }

    public void setStaffs(IStaff staffs) {
        this.staffs = staffs;
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
}