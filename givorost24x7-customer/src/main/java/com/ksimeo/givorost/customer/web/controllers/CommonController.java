package com.ksimeo.givorost.customer.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ksimeo. Created on 03.02.2017 at 14:02 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class CommonController {

    private final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping( value = {"/", "/index"}, method = RequestMethod.GET )
    public String showIndex() {
        logger.debug("showIndex()");
        return "index";
    }

    @RequestMapping( value = "/about", method = RequestMethod.GET )
    public String showAbout(Model model) {
        logger.debug("showAbout()");
        model.addAttribute("title", "Про нас");
        return "about";
    }

    @RequestMapping( value = "/products", method = RequestMethod.GET )
    public String showProducts(Model model) {
        logger.debug("showProducts()");
        model.addAttribute("title", "Наша Продукція");
        return "products";
    }

    @RequestMapping( value = "/product/{id}", method = RequestMethod.GET )
    public String showProduct(@PathVariable int id, Model model) {
        logger.debug("showProduct() id: {}", id);
        model.addAttribute("title", "Наша Продукція");
        return "products/product" + id;
    }

    @RequestMapping( value = "/articles", method = RequestMethod.GET )
    public String showArticles(Model model) {
        logger.debug("showArticles()");
        model.addAttribute("title", "Нашi статтi");
        return "articles";
    }

    @RequestMapping( value = "/article/{id}", method = RequestMethod.GET )
    public String showArticle(@PathVariable int id, Model model) {
        logger.debug("showArticle(): {}", id);
        model.addAttribute("title", "Нашi статтi");
        return "articles/article" + id;
    }

    @RequestMapping( value = "/sales", method = RequestMethod.GET )
    public String showSales(Model model) {
        logger.debug("showSales()");
        model.addAttribute("title", "Нашi акції");
        return "sales";
    }

    @RequestMapping( value = "/contacts", method = RequestMethod.GET )
    public String showContacts(Model model) {
        logger.debug("showContacts()");
        model.addAttribute("title", "Нашi контакти");
        return "contacts";
    }

    @RequestMapping( value = "/calculation", method = RequestMethod.GET )
    public String showCalculator(Model model) {
        logger.debug("showCalculator()");
        model.addAttribute("title", "Обчислення необхідної вам кількості");
        return "orders/calculator";
    }

    @RequestMapping( value = "/order/{type}/{amount}", method = RequestMethod.GET )
    public String showOrderform(@PathVariable int type, @PathVariable int amount, Model model) {
        logger.debug("showOrderform()");
        model.addAttribute("title", "Оформлення замовлення");
        return "orders/orderform";
    }
}