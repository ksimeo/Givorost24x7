package com.ksimeo.eshop.impl.services;

import com.ksimeo.eshop.api.dao.OrderDAO;
import com.ksimeo.eshop.api.services.OrderService;
import com.ksimeo.eshop.entities.dto.OrderParcel;
import com.ksimeo.eshop.entities.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:47 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrderServImpl implements OrderService {
    
    public static final int rowCount = 5;

    @Autowired
    private OrderDAO orderDao;

    public OrderServImpl() {
        //NOP
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public OrderParcel getPage(int pageNumb) {
        int from;
        int to;
        boolean isLastPage = false;
        int numb = orderDao.getCount();
        int maxFullPage = numb / rowCount;
        if (pageNumb > maxFullPage) {
            pageNumb = maxFullPage;
            isLastPage = true;
        }
        if (pageNumb > 0) {
            to = numb - ((pageNumb - 1) * rowCount);
            from = to - (rowCount - 1);
        } else {
            pageNumb = 1;
            to = numb - ((pageNumb - 1) * rowCount);
            from = to - (rowCount - 1);
        }
        List<Order> orders = orderDao.findSeveral(from, to);
        return new OrderParcel(orders, maxFullPage, isLastPage);
    }

    @Override
    public Order getOne(int id) {
        return orderDao.findOne(id);
    }

    @Override
    public void addOne(Order order) {
        orderDao.save(order);
    }

    @Override
    public void dropOne(int id) {
        orderDao.dropOne(id);
    }

    @Override
    public void dropAll() {
        orderDao.dropAll();
    }
}