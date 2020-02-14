package com.hans.shilipiaoxiang.publicservice.pojo;
import java.io.Serializable;
import java.util.List;
public class IDetailtype implements Serializable {
    private Integer id;

    private String typename;

    private Integer servicetpyeId;

    private String ddescribe;

    private String chargeType;

    private String comm;

    private String explains;

    private String picturepath1;

    private String picturepath2;

    private Double price;

    private Integer typeId;

    private List<IServiceItem> iServiceItemList;

    public List<IServiceItem> getiServiceItemList() {
        return iServiceItemList;
    }

    public void setiServiceItemList(List<IServiceItem> iServiceItemList) {
        this.iServiceItemList = iServiceItemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getServicetpyeId() {
        return servicetpyeId;
    }

    public void setServicetpyeId(Integer servicetpyeId) {
        this.servicetpyeId = servicetpyeId;
    }

    public String getDdescribe() {
        return ddescribe;
    }

    public void setDdescribe(String ddescribe) {
        this.ddescribe = ddescribe == null ? null : ddescribe.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
    }

    public String getPicturepath1() {
        return picturepath1;
    }

    public void setPicturepath1(String picturepath1) {
        this.picturepath1 = picturepath1 == null ? null : picturepath1.trim();
    }

    public String getPicturepath2() {
        return picturepath2;
    }

    public void setPicturepath2(String picturepath2) {
        this.picturepath2 = picturepath2 == null ? null : picturepath2.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}