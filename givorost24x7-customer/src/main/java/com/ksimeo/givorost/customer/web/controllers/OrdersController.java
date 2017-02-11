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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
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


//    @RequestMapping(value = "calculator", method = RequestMethod.GET)
//    public String showCalculator() {
//        logger.debug("showCalculator()");
//        return "calculator";
//    }

    @RequestMapping( value = "/order/{numb}/{type}", method = RequestMethod.GET )
    public String showOrderForm(@PathVariable("numb") int numb, @PathVariable("type") int type, Model model) {
        logger.debug("showOrderForm()");
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

    @RequestMapping( value = "/orders", method = RequestMethod.POST)
    public String saveOrderForm(@ModelAttribute("orderForm") @Validated OrderDTO order, BindingResult result,
                                Model model, ModelMap modelMap, ServletRequest req, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrderForm()");
        try {
            String prodId = req.getParameter("prod");
            int id = Integer.parseInt(prodId);
            ProductDTO prodDto = prodServ.getOne(id);
            order.setProd(prodDto);
            logger.info("saveOrderForm(): ", prodDto);
            if (result.hasErrors()) {
                model.addAttribute("orderForm", order);
                return "orders/orderform";
            } else {
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("msg", "Ваш заказ принят! Мы свяжемся с вами в ближайшее время!");
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
            OrderDTO order = ordServ.getOne(id);
            ProductDTO prod = order.getProd();
            if (order == null) {
                model.addAttribute("css", "danger");
                model.addAttribute("msg", "Сервис допустил ошибку. Пожалуйста, попробуйте повторить позже.");
            }
            model.addAttribute("order", order);
            model.addAttribute("prod_name", prod.getName());
            return "orders/confirmation";
        } catch (Exception e) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Сервис допустил ошибку. Пожалуйста, попробуйте повторить позже.");
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping( value = "/order", method = RequestMethod.POST)
    private String showConfirmation(OrderDTO order ,Model model, HttpServletRequest req, HttpServletResponse resp) {
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
            String name = order.getName();
            if (name != null) {
                Cookie userName = new Cookie("name", name);
                resp.addCookie(userName);
            }
            String email = order.getEmail();
            if (email != null) {
                Cookie userEmail = new Cookie("emeil", email);
                resp.addCookie(userEmail);
            }
            model.addAttribute("order", order);
            model.addAttribute("css", "success");
            model.addAttribute("msg", "Дякуємо за ваше замовлення! Ми зв'яжемося з вами найближчим часом");
            return "orders/confirmation";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Шкода, але на сервісі виникла помилка. Будь ласка, спробуйте ще раз пізніше");
            return "orders/confirmation";
        }
    }
}