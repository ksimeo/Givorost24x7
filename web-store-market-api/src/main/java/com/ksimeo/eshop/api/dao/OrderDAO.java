package com.ksimeo.eshop.api.dao;

import com.ksimeo.eshop.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:49 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderDAO {

    Order save(Order order);
    Order findOne(int id);
    List<Order> findSeveral(int from, int to);
    List<Order> findAll();
    void dropOne(int id);
    void dropAll();
    int getCount();
}
