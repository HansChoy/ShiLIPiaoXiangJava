package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class LabelValue implements Serializable {
    private String value;
    private String label;


    public LabelValue (String label, String value){
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LabelValue{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
