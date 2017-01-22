package com.ksimeo.eshop.impl.services.mocks;

import com.ksimeo.eshop.api.services.OrderService;
import com.ksimeo.eshop.entities.dto.OrderParcel;
import com.ksimeo.eshop.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:23 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderServerImpl implements OrderService {

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public OrderParcel getPage(int page) {
        return null;
    }

    @Override
    public Order getOne(int id) {
        return null;
    }

    @Override
    public void addOne(Order ones) {

    }

    @Override
    public void dropOne(int id) {

    }

    @Override
    public void dropAll() {

    }
}
