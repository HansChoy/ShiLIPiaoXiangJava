package com.hans.shilipiaoxiang.applet.pojo;
import java.io.Serializable;
import java.util.List;

public class CGoodsTypes {
    private Integer id;

    private String text;

    private Integer info;

    private List<CGoods> cGoods;

    public List<CGoods> getcGoods() {
        return cGoods;
    }

    public void setcGoods(List<CGoods> cGoods) {
        this.cGoods = cGoods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }
}