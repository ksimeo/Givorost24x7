package com.ksimeo.givorost.core.models;

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
    private String tel;
    @Column(name = "email")
    private String email;
    @Column(name = "prod_name")
    private String prod;
    @Column
    private Integer amount;


    public Order() {
        //NOP
    }

    public Order(int id, String name, String telNumber, String prodName, int amount) {
        this.id = id;
        this.name = name;
        this.tel = telNumber;
        this.prod = prodName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        if (tel != null ? !tel.equals(order.tel) : order.tel != null) return false;
        if (email != null ? !email.equals(order.email) : order.email != null) return false;
        if (prod != null ? !prod.equals(order.prod) : order.prod != null) return false;
        return !(amount != null ? !amount.equals(order.amount) : order.amount != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (prod != null ? prod.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
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
                '}';
    }
}