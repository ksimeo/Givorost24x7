package com.ksimeo.givorost.core.models;

import javax.persistence.*;

/**
 * @author Ksimeo. Created on 12.01.2017 at 17:00 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "commodities")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private float coeff;
    @Column
    private float price;

    public Product() {
        //NOP
    }

    public Product(String name, float coeff, float price) {
        this.name = name;
        this.coeff = coeff;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoeff() {
        return coeff;
    }

    public void setCoeff(float coeff) {
        this.coeff = coeff;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}