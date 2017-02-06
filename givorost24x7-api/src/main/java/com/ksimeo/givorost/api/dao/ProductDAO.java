package com.ksimeo.givorost.api.dao;

import com.ksimeo.givorost.core.dto.ProductDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:01 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public interface ProductDAO {

    ProductDTO saveOrUpdate(ProductDTO prod);
    ProductDTO findOne(int id);
    List<ProductDTO> findAll();
    void dropOne(int id);
    void dropAll();
}
