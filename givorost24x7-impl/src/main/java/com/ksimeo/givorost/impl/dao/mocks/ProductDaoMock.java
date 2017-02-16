package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
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
        products = new ArrayList<>(5);
        products.add(new ProductDTO(1, "Продукт 1", 1.99f, 2.43f));
        products.add(new ProductDTO(2, "Продукт 2", 0.97f, 0.99f));
        products.add(new ProductDTO(3, "Продукт 3", 1.27f, 0.75f));
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO prod) {
        if (prod.getId() != null) {
            dropOne(prod.getId());
//            products.remove(prod.getId() - 1);
            products.add(prod.getId() - 1, prod);
        } else {
            products.add(prod);
            prod.setId(products.indexOf(prod) + 1);
        }
        return prod;
    }

    @Override
    public ProductDTO findOne(int id) {
        for (ProductDTO prod : products) {
            if (prod.getId() == id) return prod;
        }
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        if (products.size() != 0) return products;
        else return null;
    }

    @Override
    public void dropOne(int id) {
        for (ProductDTO prod : products) {
            if (prod.getId() == id) {
                int prodId = products.indexOf(prod);
                products.remove(prodId);
                break;
            }
        }
    }

    @Override
    public void dropAll() {
        products.clear();
    }
}
