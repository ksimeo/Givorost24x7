package com.ksimeo.givorost.repository.controllers;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDAO prodDao;

    @RequestMapping( value = "product/addone", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE
            + ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public int addProd(@RequestBody ProductDTO prod) {
        logger.debug("delProd(): {}", prod);
        return prodDao.saveOrUpdate(prod);
    }


    @RequestMapping( value = "product/getone/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public ProductDTO getProd(@PathVariable int id) {
        logger.debug("getProdName()");
        return prodDao.findOne(id);
    }


    @RequestMapping( value = "product/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE +
            ";charset=UTF-8")
    @ResponseBody
    public List<ProductDTO> getAllProducts(Model model) {
        logger.debug("getAllProducts()");
        List<ProductDTO> toSend = prodDao.findAll();
        model.addAttribute("prods", toSend);
        return prodDao.findAll();
    }

    @RequestMapping( value = "product/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delProduct(@PathVariable int id) {
        logger.debug("delProduct() id={}", id);
        prodDao.dropOne(id);
    }
}
