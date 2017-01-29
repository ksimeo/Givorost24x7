package com.ksimeo.givorost.admin.web.controllers;

import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.parcels.OrderPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ksimeo. Created on 17.01.2017 at 15:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService ordServ;

    @RequestMapping( value = "/", method = RequestMethod.GET)
    public String init() {
        logger.debug("init()");
        return "redirect:/showorderspage/1";
    }

    @RequestMapping( value = "/showorderspage/{page:.+}", method = RequestMethod.GET)
    public String showOrdersPage(@PathVariable int page, Model model) {
        try {
            logger.debug("showOrdersPage() : {}", page);
            OrderPage ordPage = ordServ.getPage(page);
            model.addAttribute("orders", ordPage.getOrders());
            model.addAttribute("pagin", ordPage.getPagination());
            model.addAttribute("currpage", page);
            return "orders/main";
        } catch (Exception e) {
            logger.error("showOrderPage()");
            e.printStackTrace();
            return null;
        }
    }

}
