package com.ksimeo.givorost.impl.services.mocks;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.parcels.OrderPage;
import com.ksimeo.givorost.core.utilities.DatesHelper;
import com.ksimeo.givorost.impl.utilites.PagesHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 16:47 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
//@Service
public class OrderServMock implements OrderService {

    public static final int rowMaxCountOnPage = 5;

    @Autowired
    private OrderDAO ordDao;

    public OrderServMock() {
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
        int maxFullPage = numb / rowMaxCountOnPage;
        if (pageNumb > maxFullPage) {
            pageNumb = maxFullPage;
            isLastPage = true;
        }
        if (pageNumb > 0) {
            to = numb - ((pageNumb - 1) * rowMaxCountOnPage);
            from = to - (rowMaxCountOnPage - 1);
        } else {
            pageNumb = 1;
            to = numb - ((pageNumb - 1) * rowMaxCountOnPage);
            from = to - (rowMaxCountOnPage - 1);
        }
        List<OrderDTO> orders = ordDao.findSeveral(from, to);
//        int rowCount = ordDao.getCount();
        int pageCount = PagesHelper.getPageCount(14);
        List<String> pagin = PagesHelper.getPagination(pageNumb, pageCount, rowMaxCountOnPage);
        return new OrderPage(orders, pageCount, pagin);
    }

    @Override
    public OrderDTO getOne(int id) {
        return ordDao.findOne(id);
    }

    @Override
    public Integer addOne(OrderDTO order) {
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

    @Override
    public void markAsReaded(int id) throws Exception {
        OrderDTO ord = ordDao.findOne(id);
        ord.setReadDate(DatesHelper.format(new Date()));
    }
}