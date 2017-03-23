package com.ksimeo.givorost.core.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ksimeo. Created on 22.01.2017 at 20:56 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -2205638583929667961L;

    private Integer id;
    private String name;
    private String tel;
    private String email;
    private String prodName;
    private Integer amount;
    private String createDate;
    private String readDate;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, String name, String tel, String prodName, String readDate, Integer amount) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.prodName = prodName;
        this.createDate = new Date().toString();
        this.readDate = readDate;
        this.amount = amount;
    }

    public OrderDTO(String name, String tel, String prodName, String readDate, Integer amount) {
        this.name = name;
        this.tel = tel;
        this.prodName = prodName;
        this.createDate = new Date().toString();
        this.readDate = readDate;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", prodName='" + prodName + '\'' +
                ", amount=" + amount +
                ", createDate='" + createDate + '\'' +
                ", readDate=" + readDate +
                '}';
    }
}
