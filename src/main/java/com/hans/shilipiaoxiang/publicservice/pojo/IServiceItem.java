package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class IServiceItem implements Serializable {
    private Integer id;

    private Integer detailtypeId;

    private String content;

    private String standard;

    private String comm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDetailtypeId() {
        return detailtypeId;
    }

    public void setDetailtypeId(Integer detailtypeId) {
        this.detailtypeId = detailtypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }
}