package com.ksimeo.eshop.api.services;

import com.ksimeo.eshop.entities.dto.OrderParcel;
import com.ksimeo.eshop.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 15:43 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderService {

    List<Order> getAll();
    OrderParcel getPage(int page);
    Order getOne(int id);
    void addOne(Order ones);
    void dropOne(int id);
    void dropAll();
}
