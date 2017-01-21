package com.ksimeo.eshop.impl.dao;

import com.ksimeo.eshop.api.dao.OrderDAO;
import com.ksimeo.eshop.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:55 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderDao implements OrderDAO {

    @Override
    public Order save(Order order) {
        return null;
    }


    public Order findOne(String login, String password) {
        return null;
    }

    @Override
    public Order findOne(int id) {
        return null;
    }

    @Override
    public List<Order> findSeveral(int from, int to) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void dropOne(int id) {

    }

    @Override
    public void dropAll() {

    }

    @Override
    public int getCount() {
        return 0;
    }
}