package com.ksimeo.givorost.core.models;

import javax.persistence.*;

/**
 * @author Ksimeo. Created on 02.02.2017 at 20:38 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "crop")
public class Crop {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column(name = "count_coeff")
    private float countCoeff;
    @Column
    private float priceCoeff;

    public Crop() {
    }

    public Crop(String name, float countCoeff, float priceCoeff) {
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
