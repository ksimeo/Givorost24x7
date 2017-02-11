package com.ksimeo.givorost.impl.services;

import com.ksimeo.givorost.api.services.ProductService;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.impl.config.RepoServerConfig;
import com.ksimeo.givorost.impl.utilites.RequestsHelper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * @author Ksimeo. Created on 01.02.2017 at 20:58 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class ProductServImpl implements ProductService {

    private String URI;

    private ObjectMapper mapper;

    @Override
    public void addOne(ProductDTO product) throws Exception{
        URI = RepoServerConfig.URL + "product/addone";
        String data = mapper.writeValueAsString(product);
        String echo = RequestsHelper.sendPost(URI, data);
    }

    @Override
    public ProductDTO getOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "product/getone/" + id;
        String echo = RequestsHelper.sendGet(URI);
        ProductDTO toSend = mapper.readValue(echo, ProductDTO.class);
        return toSend;
    }

    @Override
    public List<ProductDTO> getAll() throws Exception {
        URI = RepoServerConfig.URL + "prod/getall";
        String echo = RequestsHelper.sendGet(URI);
        List<ProductDTO> toSend = mapper.readValue(echo, new TypeReference<List<ProductDTO>>(){});
        return toSend;
    }

    @Override
    public void delOne(int id) throws Exception{
        URI = RepoServerConfig.URL + "prod/delone/" + id;
        RequestsHelper.sendGet(URI);
    }

    @Override
    public void delAll() {

    }
}