package com.hans.shilipiaoxiang.publicservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class IEvaluate {
    private Integer id;

    private Integer orderId;

    private Integer qualityValuation;

    private Integer attitudeValuation;

    private String eDescribe;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date finallytime;

    private IOrder order;

    private IDetailtype detailtype;

    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQualityValuation() {
        return qualityValuation;
    }

    public void setQualityValuation(Integer qualityValuation) {
        this.qualityValuation = qualityValuation;
    }

    public Integer getAttitudeValuation() {
        return attitudeValuation;
    }

    public void setAttitudeValuation(Integer attitudeValuation) {
        this.attitudeValuation = attitudeValuation;
    }

    public String geteDescribe() {
        return eDescribe;
    }

    public void seteDescribe(String eDescribe) {
        this.eDescribe = eDescribe == null ? null : eDescribe.trim();
    }

    public Date getFinallytime() {
        return finallytime;
    }

    public void setFinallytime(Date finallytime) {
        this.finallytime = finallytime;
    }
}