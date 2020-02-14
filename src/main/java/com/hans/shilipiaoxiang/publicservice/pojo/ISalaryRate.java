package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;

public class ISalaryRate  implements Serializable {
    private Integer id;

    private Double bonusrate;

    private Double rolaty;

    private Integer servicetypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBonusrate() {
        return bonusrate;
    }

    public void setBonusrate(Double bonusrate) {
        this.bonusrate = bonusrate;
    }

    public Double getRolaty() {
        return rolaty;
    }

    public void setRolaty(Double rolaty) {
        this.rolaty = rolaty;
    }

    public Integer getServicetypeId() {
        return servicetypeId;
    }

    public void setServicetypeId(Integer servicetypeId) {
        this.servicetypeId = servicetypeId;
    }
}