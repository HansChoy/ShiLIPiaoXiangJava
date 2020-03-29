package com.hans.shilipiaoxiang.applet.pojo;
import java.io.Serializable;
import java.util.List;
public class CEvaluate {
    private Integer id;

    private Integer orderId;

    private Integer userId;

    private Integer rate;

    private String text;

    private Long evaluatedTime;

    private Integer state;

    private String userName;

    private List<CEvaluateReply> cEvaluateReplyList;

    public List<CEvaluateReply> getcEvaluateReplyList() {
        return cEvaluateReplyList;
    }

    public void setcEvaluateReplyList(List<CEvaluateReply> cEvaluateReplyList) {
        this.cEvaluateReplyList = cEvaluateReplyList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Long getEvaluatedTime() {
        return evaluatedTime;
    }

    public void setEvaluatedTime(Long evaluatedTime) {
        this.evaluatedTime = evaluatedTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}