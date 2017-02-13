package com.ksimeo.givorost.admin.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ksimeo. Created on 17.01.2017 at 15:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ProductController {

    @RequestMapping( value = "/products", method = RequestMethod.GET)
    private String getAllProducts() {
        return null;
    }

    @RequestMapping( value = "/products/add", method = RequestMethod.POST )
    private String addNewProduct() {
        return null;
    }

    @RequestMapping( value = "products/del/{id}", method = RequestMethod.GET )
    private String deleteProduct(@PathVariable int id) {
        return null;
    }

    @RequestMapping( value = "products/change/{id}", method = RequestMethod.GET )
    private String changeProduct(@PathVariable int id) {
        return null;
    }
}
