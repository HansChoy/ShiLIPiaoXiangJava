package com.shixun.ihome.publicservice.pojo;

public class ISalary {
    private Integer id;

    private Double basesalary;

    private Double bonus;

    private Double royalty;

    private Double ssum;

    private Integer staffId;

    private IStaff iStaff;

    public IStaff getiStaff() {
        return iStaff;
    }

    public void setiStaff(IStaff iStaff) {
        this.iStaff = iStaff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(Double basesalary) {
        this.basesalary = basesalary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getRoyalty() {
        return royalty;
    }

    public void setRoyalty(Double royalty) {
        this.royalty = royalty;
    }

    public Double getSsum() {
        return ssum;
    }

    public void setSsum(Double ssum) {
        this.ssum = ssum;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}