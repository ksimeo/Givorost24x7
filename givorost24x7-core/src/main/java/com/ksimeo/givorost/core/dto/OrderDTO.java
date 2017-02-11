package com.ksimeo.givorost.core.dto;

import java.io.Serializable;

/**
 * @author Ksimeo. Created on 22.01.2017 at 20:56 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -2205638583929667961L;

    private Integer id;
    private String name;
    private String tel;
    private String email;
    private ProductDTO prod;
    private Integer amount;


    public OrderDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ProductDTO getProd() {
        return prod;
    }

    public void setProd(ProductDTO prod) {
        this.prod = prod;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", prod=" + prod +
                ", amount=" + amount +
                '}';
    }
}
