package com.ksimeo.givorost.repository.web.controllers;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.dto.OrderDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:26 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class OrderController {

    public final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderDAO ordDao;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping( value = "orders/addone", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderDTO addOrder(@RequestBody OrderDTO order) throws IOException {
        try {
            logger.debug("addOrder() : {}", order);
            System.err.println("Полученный объект: " + order);
            OrderDTO toSend = ordDao.saveOrUpdate(order);
            System.err.println("Отправляемый объект: " + toSend);
            return toSend;
        } catch (Exception e) {
            logger.debug("addOrder(): mapping error");
         e.printStackTrace();
            return null;
        }
    }

    @RequestMapping( value = "orders/getone/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public OrderDTO getOrder(@PathVariable int id) {
        logger.debug("getOrder() id: {}", id);
        return ordDao.findOne(id);
    }

    @RequestMapping( value = "orders/getcount", method = RequestMethod.GET)
    @ResponseBody
    public int getOrdersCount() {
        logger.debug("getOrdersCount()");
        return ordDao.getCount();
    }

    @RequestMapping( value = "/getorders/{from}/{to}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<OrderDTO> getOrders(@PathVariable int from, @PathVariable int to) {
        logger.debug("getOrders() from: {}, to: {}", from, to);
        return ordDao.findSeveral(from, to);
    }

    @RequestMapping( value = "orders/delone/{id}", method = RequestMethod.GET)
    public void delOrder(@PathVariable int id) {
        logger.debug("delOrder(): {}", id);
        ordDao.dropOne(id);
    }

    @RequestMapping( value = "orders/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE +
            ";charset=UTF-8")
    @ResponseBody
    public List<OrderDTO> getAllOrders() {
        logger.debug("getAllOrders()");
        return ordDao.findAll();
    }
}