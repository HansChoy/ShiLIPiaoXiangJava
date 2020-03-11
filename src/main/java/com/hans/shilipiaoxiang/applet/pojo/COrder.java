package com.hans.shilipiaoxiang.applet.pojo;
import java.io.Serializable;
import java.util.List;

public class COrder {
    private Integer id;

    private Integer wxId;

    private String code;

    private String orderno;

    private Integer total;

    private Double price;

    private Long ordertime;

    private String note;

    private Integer type;

    private Integer state;

    private List<CGoods> cGoodsList;

    public List<CGoods> getcGoodsList() {
        return cGoodsList;
    }

    public void setcGoodsList(List<CGoods> cGoodsList) {
        this.cGoodsList = cGoodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWxId() {
        return wxId;
    }

    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Long ordertime) {
        this.ordertime = ordertime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}