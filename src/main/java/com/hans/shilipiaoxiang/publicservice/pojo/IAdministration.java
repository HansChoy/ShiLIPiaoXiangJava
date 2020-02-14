package com.hans.shilipiaoxiang.publicservice.pojo;

import java.io.Serializable;


public class IAdministration implements Serializable {
    private Integer id;

    private String idCard;

    private String name;

    private String phone;

    private Integer sex;

    private Integer age;

    private String address;

    private String account;

    private String pwd;

    private Integer positionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "IAdministration{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", positionId=" + positionId +
                '}';
    }
}