package com.ksimeo.givorost.repository.web.controllers;

import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:26 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class OrderController {

    public final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping( value = "/addorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE +
            ";charset=UTF-8")
    public void addOrder(Order order) {
        logger.debug("addOrder() : {}", order);
        orderService.addOne(order);
    }
}
