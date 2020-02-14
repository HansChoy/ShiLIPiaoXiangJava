package com.hans.shilipiaoxiang.publicservice.pojo;

public class IOrderNews {
    private Integer id;

    private Integer orderId;

    private String oDescribe;

    private String solve;

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

    public String getoDescribe() {
        return oDescribe;
    }

    public void setoDescribe(String oDescribe) {
        this.oDescribe = oDescribe == null ? null : oDescribe.trim();
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve == null ? null : solve.trim();
    }
}