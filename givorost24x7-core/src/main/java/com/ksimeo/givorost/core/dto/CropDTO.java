package com.ksimeo.givorost.core.dto;

/**
 * @author Ksimeo. Created on 02.02.2017 at 20:46 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class CropDTO {
    private int id;
    private String name;
    private float countCoeff;
    private float priceCoeff;

    public CropDTO() {
    }

    public CropDTO(int id, String name, float countCoeff, float priceCoeff) {
        this.id = id;
        this.name = name;
        this.countCoeff = countCoeff;
        this.priceCoeff = priceCoeff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCountCoeff() {
        return countCoeff;
    }

    public void setCountCoeff(float countCoeff) {
        this.countCoeff = countCoeff;
    }

    public float getPriceCoeff() {
        return priceCoeff;
    }

    public void setPriceCoeff(float priceCoeff) {
        this.priceCoeff = priceCoeff;
    }
}
