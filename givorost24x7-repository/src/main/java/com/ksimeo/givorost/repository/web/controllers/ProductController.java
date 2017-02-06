package com.ksimeo.givorost.repository.web.controllers;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:01 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDAO prodDao;

    @RequestMapping( value = "prod/addone", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProd(ProductDTO prod) {
        logger.debug("delProd(): {}", prod);
        prodDao.saveOrUpdate(prod);
    }


    @RequestMapping( value = "prod/getone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductDTO getProd(@PathVariable int id) {
        logger.debug("getProd()");
        return prodDao.findOne(id);
    }


    @RequestMapping( value = "prod/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductDTO> getAllProducts() {
        logger.debug("getAllProducts()");
        return prodDao.findAll();
    }

    @RequestMapping( value = "prod/delprod/{id}", method = RequestMethod.GET)
    public void delProduct(@PathVariable int id) {
        logger.debug("delProduct() id={}", id);
        prodDao.dropOne(id);
    }
}
