package com.ksimeo.eshop.customer.web.controllers;

import com.ksimeo.eshop.api.services.OrderService;
import com.ksimeo.eshop.customer.validators.OrderFormValidator;
import com.ksimeo.eshop.entities.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    OrderFormValidator orderFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(orderFormValidator);
    }

    @RequestMapping( value = {"/", "/index"}, method = RequestMethod.GET )
    public String index() {
        logger.debug("index()");
        return "redirect:/orders/add";
    }

    @RequestMapping( value = "/orders/add", method = RequestMethod.GET )
    public String showOrderForm(Model model) {
        logger.debug("showOrderForm()");
        Order order = new Order();
        model.addAttribute("orderForm", order);
        return "orders/orderform";
    }

    @RequestMapping( value = "/orders", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("orderForm") @Validated Order order, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("saveOrder() : {}", order);

        if (result.hasErrors()) {
            model.addAttribute("orderForm", order);
            return "orders/orderform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(order.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Ваш заказ успешно оформлен! Наши сотрудники свяжутся" +
                        " с вами в ближайшее время");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Ваш заказ успешно оформлен! Наши сотрудники свяжутся" +
                        " с вами в ближайшее время");
            }

            ordServ.addOne(order);

            System.out.println("Полученный Order: " + order);

            return "redirect:/orders/" + order.getId();
        }
    }


    @RequestMapping( value = "/orders/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable("id") int id, Model model) {

        logger.debug("showOrder() id: {}", id);

        Order order = ordServ.getOne(id);
        if (order == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "В работе сервиса возникла ошибка. Пожалуйста, попробуйте позже.");
        }
        model.addAttribute("order", order);

        return "orders/show";
    }
}