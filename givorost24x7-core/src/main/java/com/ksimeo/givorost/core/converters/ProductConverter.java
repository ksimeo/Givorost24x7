package com.ksimeo.givorost.core.converters;

import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.core.models.Product;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:15 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class ProductConverter {

    private ProductConverter() {
    }

    public static Product convert(ProductDTO prodDTO) {
        Product toSend = new Product();
        toSend.setName(prodDTO.getName());
        toSend.setCoeff(prodDTO.getCoeff());
        toSend.setPrice(prodDTO.getPrice());
        return toSend;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO toSend = new ProductDTO();
        toSend.setName(product.getName());
        toSend.setCoeff(product.getCoeff());
        toSend.setPrice(product.getPrice());
        return toSend;
    }
}