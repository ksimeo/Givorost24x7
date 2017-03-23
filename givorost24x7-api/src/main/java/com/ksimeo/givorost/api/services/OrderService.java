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

    Integer addOne(OrderDTO one) throws Exception;
    OrderDTO getOne(int id) throws Exception;
    OrderPage getPage(int page) throws Exception;
    List<OrderDTO> getAll() throws Exception;
    void markAsReaded(int id) throws Exception;
    void dropOne(int id) throws Exception;
    void dropAll() throws Exception;
}
