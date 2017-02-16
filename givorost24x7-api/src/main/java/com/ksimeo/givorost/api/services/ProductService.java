package com.ksimeo.givorost.api.services;

import com.ksimeo.givorost.core.dto.ProductDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 20:52 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public interface ProductService {

    ProductDTO addOne(ProductDTO product) throws Exception;
    ProductDTO getOne(int id) throws Exception;
    List<ProductDTO> getAll() throws Exception;
    void delOne(int id) throws Exception;
    void delAll() throws Exception;
}
