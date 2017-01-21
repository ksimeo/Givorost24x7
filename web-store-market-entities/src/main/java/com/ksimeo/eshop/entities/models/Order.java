package com.ksimeo.eshop.entities.models;

import javax.persistence.*;

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
    private int id;
    @Column
    private String name;
    @Column(name = "tel_number")
    private String telNumber;
    @Column(name = "prod_name")
    private String prodName;
    @Column
    private int amount;

    public Order() {
        //NOP
    }

    public Order(int id, String name, String telNumber, String prodName, int amount) {
        this.id = id;
        this.name = name;
        this.telNumber = telNumber;
        this.prodName = prodName;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}