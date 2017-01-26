package com.ksimeo.givorost.api.services;

import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.parcels.OrderPage;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 15:43 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderService {

    OrderDTO addOne(OrderDTO one);
    OrderDTO getOne(int id);
    OrderPage getPage(int page);
    List<OrderDTO> getAll();
    void dropOne(int id);
    void dropAll();
}
