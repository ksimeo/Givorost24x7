package com.ksimeo.givorost.api.dao;

import com.ksimeo.givorost.core.dto.OrderDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:49 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderDAO {

    Integer saveOrUpdate(OrderDTO order);
    OrderDTO findOne(int id);
    List<OrderDTO> findSeveral(int from, int to);
    List<OrderDTO> findAll();
    void dropOne(int id);
    void dropAll();
    int getCount();
}
