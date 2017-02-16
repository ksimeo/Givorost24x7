package com.ksimeo.givorost.impl.services.mocks;

import com.ksimeo.givorost.api.services.ProductService;
import com.ksimeo.givorost.core.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 09.02.2017 at 18:59 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
//@Service
public class ProductServMock implements ProductService {

    private List<ProductDTO> prods;

    public ProductServMock() {
        prods = new ArrayList<>(5);
        prods.add(new ProductDTO(1, "Біогумат для відкритого грунту", 0.1f, 0.0f));
        prods.add(new ProductDTO(2, "Біогумат для закритого грунту", 0.25f, 0.0f));
    }

    @Override
    public ProductDTO addOne(ProductDTO product) throws Exception {
        prods.add(product);
        int id = prods.indexOf(product);
        product.setId(id + 1);
        return product;
    }

    @Override
    public ProductDTO getOne(int id) throws Exception {
        return prods.get(id - 1);
    }

    @Override
    public List<ProductDTO> getAll() throws Exception {
        return prods;
    }

    @Override
    public void delOne(int id) throws Exception {
        prods.remove(id - 1);
    }

    @Override
    public void delAll() throws Exception {
        prods.clear();
    }
}
