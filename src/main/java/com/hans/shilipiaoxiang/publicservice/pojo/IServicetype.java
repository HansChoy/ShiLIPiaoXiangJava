package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class IServicetype implements Serializable {
    private Integer id;

    private String serviceType;

    private String sdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getSdescribe() {
        return sdescribe;
    }

    public void setSdescribe(String sdescribe) {
        this.sdescribe = sdescribe == null ? null : sdescribe.trim();
    }
}