package com.ksimeo.givorost.admin.web.controllers;

import com.ksimeo.givorost.api.services.ProductService;
import com.ksimeo.givorost.core.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 15:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ProductController {

    public final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService prodServ;

    @RequestMapping( value = "/products", method = RequestMethod.GET)
    private String showAllProducts(Model model) {
        logger.debug("showAllProducts()");
        try {
            List<ProductDTO> prods = prodServ.getAll();
            model.addAttribute("prods", prods);
            return "products/products";
        } catch (Exception e) {
            logger.error("showAllProducts()");
            e.printStackTrace();
            return "products/products";
        }
    }

    @RequestMapping( value = "/products/add", method = RequestMethod.GET )
    public String showAddingForm(Model model) {
        logger.debug("showAddingForm()");
        ProductDTO prod = new ProductDTO();
        model.addAttribute("prodForm", prod);
        return "products/productsform";
    }

    @RequestMapping( value = "/products/add", method = RequestMethod.POST )
    private String addNewProduct(ProductDTO prod, RedirectAttributes redirectAttributes) {
        logger.debug("addNewProduct(): {}", prod);
        try {
            System.out.println("prod: " + prod);
            prodServ.addOne(prod);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Продукт успішно додан!");
            return "redirect:/products";
        } catch (Exception e) {
            logger.error("addNewProduct(): {}", prod);
            e.printStackTrace();
            return "redirect:/products";
        }
    }

    @RequestMapping( value = "products/change/{id}", method = RequestMethod.GET )
    private String changeProduct(@PathVariable int id, Model model) {
        logger.debug("changeProduct() id: {}", id);
        try {
            ProductDTO prod = prodServ.getOne(id);
            model.addAttribute("prodForm", prod);
            return "products/productsform";
        } catch (Exception e) {
            logger.error("changeProduct()");
            e.printStackTrace();
            return "redirect:/products";
        }
    }

    @RequestMapping( value = "products/delete/{id}", method = RequestMethod.GET )
    private String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
        logger.debug("deleteProduct()");
        try {
            prodServ.delOne(id);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Продукт успішно видалено!");
            return "redirect:/products";
        } catch (Exception e) {
            logger.error("deleteProduct()");
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Продукт не вдалося видалити!");
            e.printStackTrace();
            return "products/products";
        }
    }
}