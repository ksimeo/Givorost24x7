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
    private Integer id;
    @Column
    private String name;
    @Column(name = "tel_number")
    private String telNumber;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "prod_name")
    private String prodName;
    @Column
    private Integer amount;


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

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        if (telNumber != null ? !telNumber.equals(order.telNumber) : order.telNumber != null) return false;
        if (eMail != null ? !eMail.equals(order.eMail) : order.eMail != null) return false;
        if (prodName != null ? !prodName.equals(order.prodName) : order.prodName != null) return false;
        return !(amount != null ? !amount.equals(order.amount) : order.amount != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (prodName != null ? prodName.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                ", prodName='" + prodName + '\'' +
                ", amount=" + amount +
                '}';
    }
}