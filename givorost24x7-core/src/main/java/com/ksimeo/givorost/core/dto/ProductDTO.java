package com.ksimeo.givorost.core.dto;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:08 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class ProductDTO {

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
}