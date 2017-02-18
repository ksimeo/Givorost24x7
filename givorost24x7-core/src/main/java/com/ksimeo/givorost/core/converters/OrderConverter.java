package com.ksimeo.givorost.core.converters;

import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;
import com.ksimeo.givorost.core.utilities.DatesHelper;

/**
 * @author Ksimeo. Created on 22.01.2017 at 20:52 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderConverter {


    public static Order convert(OrderDTO orderDto) {
        if (orderDto == null) throw new NullPointerException();

        Order toSend = new Order();

        toSend.setId(orderDto.getId());

        if (orderDto.getName().equals("не вказано")) toSend.setName(null);
        else toSend.setName(orderDto.getName());

        if (orderDto.getTel().equals("не вказано")) toSend.setTel(null);
        else toSend.setTel(orderDto.getTel());

        if (orderDto.getEmail().equals("не вказано")) toSend.setEmail(orderDto.getEmail());
        else toSend.setEmail(orderDto.getEmail());

        if (orderDto.getProdName().equals("не вказано")) toSend.setProd(null);
        else toSend.setProd(orderDto.getProdName());

        toSend.setAmount(orderDto.getAmount());

        if (orderDto.getCreateDate() != null) toSend.setCreateDate(DatesHelper.parseToSQLDate(orderDto.getCreateDate()));
        if (orderDto.getReadDate() != null) toSend.setReadDate(DatesHelper.parseToSQLDate(orderDto.getReadDate()));
        return toSend;
    }

    public static OrderDTO convert(Order order) {
        if (order == null) throw new NullPointerException();
        OrderDTO toSend = new OrderDTO();
        toSend.setId(order.getId());

        if (order.getName() != null) toSend.setName(order.getName());
        else toSend.setName("не вказано");

        if (order.getTel() != null) toSend.setTel(order.getTel());
        else toSend.setTel("не вказано");

        if (order.getEmail() != null) toSend.setEmail(order.getEmail());
        else toSend.setEmail("не вказано");

        if (order.getProd() != null) toSend.setProdName(order.getProd());
        else toSend.setProdName("не вказано");

        toSend.setAmount(order.getAmount());

        if (order.getCreateDate() != null) toSend.setCreateDate(DatesHelper.format(order.getCreateDate()));
        if (order.getReadDate() != null) toSend.setReadDate(DatesHelper.format(order.getReadDate()));
        return toSend;
    }
}