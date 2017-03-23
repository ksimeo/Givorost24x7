package com.ksimeo.givorost.core.dto;

import java.io.Serializable;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:08 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class ProductDTO implements Serializable {

    private Integer id;
    private String name;
    private float coeff;
    private float price;

    public ProductDTO() {
    }

    public ProductDTO(String name, float coeff, float price) {
        this.name = name;
        this.coeff = coeff;
        this.price = price;
    }

    public ProductDTO(Integer id, String name, float coeff, float price) {
        this.id = id;
        this.name = name;
        this.coeff = coeff;
        this.price = price;
    }

    public ProductDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCoeff() {
        return coeff;
    }

    public void setCoeff(float coeff) {
        this.coeff = coeff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coeff=" + coeff +
                ", price=" + price +
                '}';
    }
}