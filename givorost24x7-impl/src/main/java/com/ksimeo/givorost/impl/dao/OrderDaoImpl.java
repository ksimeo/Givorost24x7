package com.ksimeo.givorost.impl.dao;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.dto.OrderDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:55 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderDaoImpl implements OrderDAO {

    @Override
    public OrderDTO saveOrUpdate(OrderDTO order) {
        return null;
    }

    public OrderDTO findOne(String login, String password) {
        return null;
    }

    @Override
    public OrderDTO findOne(int id) {
        return null;
    }

    @Override
    public List<OrderDTO> findSeveral(int from, int to) {
        return null;
    }

    @Override
    public List<OrderDTO> findAll() {
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