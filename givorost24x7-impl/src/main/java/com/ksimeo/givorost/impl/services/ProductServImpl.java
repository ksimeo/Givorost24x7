package com.ksimeo.givorost.impl.services;

import com.ksimeo.givorost.api.services.ProductService;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.impl.config.RepoServerConfig;
import com.ksimeo.givorost.impl.utilites.RequestsHelper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 20:58 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProductServImpl implements ProductService {

    private String URI;

    private ObjectMapper mapper;

    public ProductServImpl() {
        mapper = new ObjectMapper();
    }

    @Override
    public ProductDTO addOne(ProductDTO product) throws Exception{
        URI = RepoServerConfig.URL + "product/addone";
        String data = mapper.writeValueAsString(product);
        System.out.println(data);
        String echo = RequestsHelper.sendPost(URI, data);
        return mapper.readValue(echo, ProductDTO.class);
    }

    @Override
    public ProductDTO getOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "product/getone/" + id;
        String echo = RequestsHelper.sendGet(URI);
        return mapper.readValue(echo, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAll() throws Exception {
        String echo = RequestsHelper.sendGet(RepoServerConfig.URL + "product/getall");
        return mapper.readValue(echo, new TypeReference<List<ProductDTO>>(){});
    }

    @Override
    public void delOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "product/" + id + "/delete";
        RequestsHelper.sendGet(URI);
    }

    @Override
    public void delAll() {

    }
}