package com.ksimeo.givorost.impl.services;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.parcels.OrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:23 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrderServerImpl implements OrderService {

    public static final int rowCount = 5;

    @Autowired
    private OrderDAO ordDao;

    public OrderServerImpl() {
        //NOP
    }

    @Override
    public List<OrderDTO> getAll() {
        return ordDao.findAll();
    }

    @Override
    public OrderPage getPage(int pageNumb) {
        int from;
        int to;
        boolean isLastPage = false;
        int numb = ordDao.getCount();
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
        List<OrderDTO> orders = ordDao.findSeveral(from, to);
        return new OrderPage(orders, maxFullPage, isLastPage);
    }

    @Override
    public OrderDTO getOne(int id) {
        return ordDao.findOne(id);
    }

    @Override
    public OrderDTO addOne(OrderDTO order) {
        return ordDao.saveOrUpdate(order);
    }

    @Override
    public void dropOne(int id) {
        ordDao.dropOne(id);
    }

    @Override
    public void dropAll() {
        ordDao.dropAll();
    }
}
