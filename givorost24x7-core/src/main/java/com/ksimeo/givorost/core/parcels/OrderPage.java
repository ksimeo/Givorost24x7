package com.ksimeo.givorost.core.parcels;

import com.ksimeo.givorost.core.dto.OrderDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 18:01 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderPage {

    private List<OrderDTO> orders;
    private int pageNumb;
    private boolean isLast;

    public OrderPage() {
    }

    public OrderPage(List<OrderDTO> orders, int pageNumb, boolean isLast) {
        this.orders = orders;
        this.pageNumb = pageNumb;
        this.isLast = isLast;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
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
