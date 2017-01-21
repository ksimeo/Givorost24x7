package com.ksimeo.eshop.entities.models;

import javax.persistence.*;

/**
 * @author Ksimeo. Created on 12.01.2017 at 17:00 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "commodities")
public class Commodity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int count;

    public Commodity() {
        //NOP
    }

    public Commodity(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}