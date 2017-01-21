package com.ksimeo.eshop.entities.dto;

import com.ksimeo.eshop.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 18:01 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderParcel {

    private List<Order> orders;
    private int pageNumb;
    private boolean isLast;

    public OrderParcel() {
    }

    public OrderParcel(List<Order> orders, int pageNumb, boolean isLast) {
        this.orders = orders;
        this.pageNumb = pageNumb;
        this.isLast = isLast;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }
}
