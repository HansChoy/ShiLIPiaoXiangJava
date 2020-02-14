package com.hans.shilipiaoxiang.publicservice.pojo;

public class IOrderLong {
    private Integer id;

    private Double salary;

    private Integer month;

    private String aboutFile;

    private Integer orderId;

    private IOrder order;


    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getAboutFile() {
        return aboutFile;
    }

    public void setAboutFile(String aboutFile) {
        this.aboutFile = aboutFile == null ? null : aboutFile.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}