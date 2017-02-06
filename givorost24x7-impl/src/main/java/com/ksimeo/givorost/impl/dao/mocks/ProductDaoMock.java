package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.core.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:05 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class ProductDaoMock implements ProductDAO {

    List<ProductDTO> products;


    public ProductDaoMock() {
        products = new ArrayList<>(3);
        products.add(new ProductDTO("Продукт 1", 1.99f, 2.43f));
        products.add(new ProductDTO("Продукт 2", 0.97f, 0.99f));
        products.add(new ProductDTO("Продукт 3", 1.27f, 0.75f));
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO prod) {
        return null;
    }

    @Override
    public ProductDTO findOne(int id) {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        return null;
    }

    @Override
    public void dropOne(int id) {

    }

    @Override
    public void dropAll() {

    }
}
