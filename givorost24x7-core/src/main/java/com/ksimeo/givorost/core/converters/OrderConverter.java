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

        toSend.setName(orderDto.getName());

        toSend.setTel(orderDto.getTel());

        toSend.setEmail(orderDto.getEmail());

        toSend.setProd(orderDto.getProdName());

        toSend.setAmount(orderDto.getAmount());

        if (orderDto.getCreateDate() != null) toSend.setCreateDate(DatesHelper.parseToSQLDate(orderDto.getCreateDate()));
        if (orderDto.getReadDate() != null) toSend.setReadDate(DatesHelper.parseToSQLDate(orderDto.getReadDate()));
        return toSend;
    }

    public static OrderDTO convert(Order order) {
        if (order == null) throw new NullPointerException();
        OrderDTO toSend = new OrderDTO();
        toSend.setId(order.getId());

        toSend.setName(order.getName());

        toSend.setTel(order.getTel());

        toSend.setEmail(order.getEmail());

        toSend.setProdName(order.getProd());

        toSend.setAmount(order.getAmount());

        if (order.getCreateDate() != null) toSend.setCreateDate(DatesHelper.format(order.getCreateDate()));
        if (order.getReadDate() != null) toSend.setReadDate(DatesHelper.format(order.getReadDate()));
        return toSend;
    }
}