package com.ksimeo.givorost.core.converters;

import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;

/**
 * @author Ksimeo. Created on 22.01.2017 at 20:52 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class OrderConverter {

    private OrderConverter() {
    }

    public static Order convert(OrderDTO orderDto) {
        Order toSend = new Order();
        toSend.setId(orderDto.getId());
        toSend.setName(orderDto.getName());
        toSend.setTel(orderDto.getTel());
        toSend.setEmail(orderDto.getEmail());
        toSend.setProd(orderDto.getProd());
        toSend.setAmount(orderDto.getAmount());
        return toSend;
    }

    public static OrderDTO convert(Order order) {
        OrderDTO toSend = new OrderDTO();
        toSend.setId(order.getId());
        toSend.setName(order.getName());
        toSend.setTel(order.getTel());
        toSend.setEmail(order.getEmail());
        toSend.setProd(order.getProd());
        toSend.setAmount(order.getAmount());
        return toSend;
    }
}
