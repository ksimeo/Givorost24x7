package com.ksimeo.givorost.core.models;

import javax.persistence.*;

/**
 * @author Ksimeo. Created on 12.01.2017 at 16:09 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table( name = "custoners")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "tel_number")
    private String telNumber;
    @Column(name = "e-mail")
    private String eMail;


    public Customer() {
    }

    public Customer(String name, String surname, String telNumber, String eMail) {
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
