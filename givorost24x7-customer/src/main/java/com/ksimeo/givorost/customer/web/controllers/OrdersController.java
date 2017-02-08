package com.ksimeo.givorost.customer.web.controllers;

import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.customer.validators.OrderFormValidator;
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


//    @RequestMapping(value = "calculator", method = RequestMethod.GET)
//    public String showCalculator() {
//        logger.debug("showCalculator()");
//        return "calculator";
//    }

    @RequestMapping( value = "/order/{numb}/{type}", method = RequestMethod.GET )
    public String showOrderForm(@PathVariable("numb") int numb, @PathVariable("type") int type, Model model) {
        logger.debug("showOrderForm()");
        OrderDTO order = new OrderDTO();
        if (numb != 0 && type != 0) {
            order.setAmount(numb);
//            order.
        }
        model.addAttribute("orderForm", order);
        return "orders/orderform";
    }

    @RequestMapping( value = "/orders", method = RequestMethod.POST)
    public String saveOrderForm(@ModelAttribute("orderForm") @Validated OrderDTO order, BindingResult result,
                                Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("saveOrderForm() : {}", order);
        try {
            if (result.hasErrors()) {
                model.addAttribute("orderForm", order);
                return "orders/orderform";
            } else {
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("msg", "Ваш заказ принят! Мы свяжемся с вами в ближайшее время!");
                redirectAttributes.addFlashAttribute("msg", "Ваш заказ успешно оформлен! Наши сотрудники свяжутся");
                order = ordServ.addOne(order);
                return "redirect:/orders/" + order.getId();
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Сервис допустил ошибку. Пожалуйста, попробуйте повторить позже.");
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping( value = "/orders/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable("id") int id, Model model) {
        try {
            logger.debug("showOrder() id: {}", id);
            System.err.println("showOrder() id: " + id);
            OrderDTO order = ordServ.getOne(id);
            if (order == null) {
                model.addAttribute("css", "danger");
                model.addAttribute("msg", "Сервис допустил ошибку. Пожалуйста, попробуйте повторить позже.");
            }
            model.addAttribute("order", order);
            return "orders/confirm";
        } catch (Exception e) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Сервис допустил ошибку. Пожалуйста, попробуйте повторить позже.");
            e.printStackTrace();
            return null;
        }
    }
}