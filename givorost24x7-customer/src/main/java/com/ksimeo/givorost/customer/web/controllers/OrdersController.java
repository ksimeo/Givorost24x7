package com.ksimeo.givorost.customer.web.controllers;

import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.api.services.ProductService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.customer.validators.OrderFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Ksimeo. Created on 21.01.2017 at 14:44 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrderService ordServ;
    @Autowired
    private ProductService prodServ;
    @Autowired
    OrderFormValidator orderFormValidator;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(orderFormValidator);
    }

    @RequestMapping( value = "/order/{numb}/{type}", method = RequestMethod.GET )
    public String showOrderForm(@PathVariable("numb") int numb, @PathVariable("type") int type, Model model) {
        logger.debug("showOrderForm() numb: {}, type: {}", numb, type);
        model.addAttribute("title", "Здійснення замовлення");
        try {
            List<ProductDTO> prods = prodServ.getAll();
            OrderDTO order = new OrderDTO();
            if (numb != 0 && type != 0) {
                order.setAmount(numb);
            }
            model.addAttribute("prodType", type);
            model.addAttribute("orderForm", order);
            model.addAttribute("prods", prods);
            return "orders/orderform";
        } catch (Exception e) {
            logger.error("showOrderForm()");
            e.printStackTrace();
            return "error500";
        }
    }

    @RequestMapping( value = "/order", method = RequestMethod.POST)
    private String showConfirmation(@ModelAttribute("orderForm") OrderDTO order ,Model model, HttpServletRequest req, HttpServletResponse resp) {
        logger.debug("showConfirmation()");
        model.addAttribute("title", "Здійснення замовлення");
        try {
            String prodId = req.getParameter("product");
            int id = Integer.parseInt(prodId);
            ProductDTO prod = prodServ.getOne(id);
            order.setProd(prod);
            order = ordServ.addOne(order);
            Cookie userTel = new Cookie("tel", order.getTel());
            resp.addCookie(userTel);
            model.addAttribute("order", order);
            model.addAttribute("css", "success");
            model.addAttribute("msg", "Дякуємо за ваше замовлення! Ми зв'яжемося з вами найближчим часом :)");
            return "orders/confirmation";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Шкода, але на нашому сервісі виникли негоразди.:(" +
                    " Будь ласка, спробуйте ще раз, пізніше!");
            return "orders/confirmation";
        }
    }

}