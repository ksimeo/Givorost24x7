package com.ksimeo.givorost.core.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Ksimeo. Created on 12.01.2017 at 16:58 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column(name = "tel_number")
    private String tel;
    @Column(name = "email")
    private String email;
    @Column(name = "product_name")
    private String prod;
    @Column
    private Integer amount;
    @Column(name = "time_date")
    private Date createDate;
    @Column(name = "read_date")
    private Date readDate;


    public Order() {
        createDate = new Date(System.currentTimeMillis());
    }

    public Order(int id, String name, String telNumber, String prod, int amount) {
        this.id = id;
        this.name = name;
        this.tel = telNumber;
        this.prod = prod;
        this.amount = amount;
        createDate = new Date(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", prod='" + prod + '\'' +
                ", amount=" + amount +
                ", createDate=" + createDate +
                ", readDate=" + readDate +
                '}';
    }
}