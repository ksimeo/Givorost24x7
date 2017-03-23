package com.ksimeo.givorost.admin.web.controllers;

import com.amazonaws.util.json.JSONObject;
import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.parcels.OrderPage;
import com.ksimeo.givorost.core.utilities.DatesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
        return "redirect:/orders/1";
    }


    @RequestMapping( value = "/orders/{page:.+}", method = RequestMethod.GET)
    public String showOrdersPage(@PathVariable int page, Model model) {
        try {
            logger.debug("showOrdersPage() page: {}", page);
            OrderPage ordPage = ordServ.getPage(page);
            model.addAttribute("orders", ordPage.getOrders());
            model.addAttribute("pagin", ordPage.getPagination());
            model.addAttribute("currpage", page);
            return "orders/index";
        } catch (Exception e) {
            logger.error("showOrderPage()");
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping( value = "/orders/read/{id}", method = RequestMethod.GET )
    public void doReaded(@PathVariable int id, HttpServletResponse resp) {
        try {
            logger.debug("doReaded() id: {}", id);
            resp.setContentType("application/json");
            ordServ.markAsReaded(id);
            JSONObject obj = new JSONObject();
            obj.put("date", DatesHelper.format(new Date()));
            resp.getWriter().println(obj);
        } catch (Exception e) {
            logger.error("doReaded()");
            e.printStackTrace();
        }
    }


    @RequestMapping( value = "/orders/delete/{id}/{page}", method = RequestMethod.GET)
    public String deleteOne(@PathVariable int id, @PathVariable int page) {
        logger.debug("deleteOne()");
        try {
            ordServ.dropOne(id);
            return "redirect:/orders/" + page;
        } catch (Exception e) {
            logger.error("deleteOne()");
            e.printStackTrace();
            return "redirect:/orders/" + page;
        }
    }
}