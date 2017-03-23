package com.ksimeo.givorost.impl.services;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.parcels.OrderPage;
import com.ksimeo.givorost.impl.config.RepoServerConfig;
import com.ksimeo.givorost.impl.utilites.PagesHelper;
import com.ksimeo.givorost.impl.utilites.RequestsHelper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:23 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrderServImpl implements OrderService {

    public static final int rowCount = 5;
    public static final int maxPagesPaginNumb = 10;

    private int minPageNumb;
    private int maxPageNumb;

    private String URI;
    private String echoData;
    private ObjectMapper mapper;

    @Autowired
    private OrderDAO ordDao;

    public OrderServImpl() {
        mapper = new ObjectMapper();
    }

    @Override
    public List<OrderDTO> getAll() throws Exception {
        echoData = RequestsHelper.sendGet(RepoServerConfig.URL + "orders/getall");
        return mapper.readValue(echoData, new TypeReference<List<OrderDTO>>(){ });
    }

    @Override
    public OrderPage getPage(int pageNumb) throws Exception {
        int numb = ordDao.getCount();
        PagesHelper.PageInfo pageInfo = PagesHelper.getRowNumbers(pageNumb, numb);
        int from = pageInfo.from;
        int to = pageInfo.to;
        int maxFullPage = PagesHelper.getPageCount(numb);
        URI = RepoServerConfig.URL + "getorders/" + from + "/" + to;
        System.out.println("URI: " + URI);
        echoData = RequestsHelper.sendGet(URI);
        List<OrderDTO> toSend = mapper.readValue(echoData, new TypeReference<List<OrderDTO>>() { });
        URI = RepoServerConfig.URL + "orders/getcount";
        echoData = RequestsHelper.sendGet(URI);
        int count = Integer.parseInt(echoData);
        int pagesNumb = PagesHelper.getPageCount(count);
        List<String> pagination = PagesHelper.getPagination(pageNumb, pagesNumb, maxPagesPaginNumb);
        return new OrderPage(toSend, maxFullPage, pagination);
    }

    @Override
    public OrderDTO getOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "orders/getone/" + id;
        echoData = RequestsHelper.sendGet(URI);
        return mapper.readValue(echoData, OrderDTO.class);
    }

    @Override
    public Integer addOne(OrderDTO order) throws Exception {
        URI = RepoServerConfig.URL + "orders/addone";
        String data = mapper.writeValueAsString(order);
        echoData = RequestsHelper.sendPost(URI, data);
        return mapper.readValue(echoData, OrderDTO.class).getId();
    }

    @Override
    public void markAsReaded(int id) throws Exception {
        URI = RepoServerConfig.URL + "order/" + id + "/markasreaded";
        RequestsHelper.sendGet(URI);
    }

    @Override
    public void dropOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "orders/delone/" + id;
        RequestsHelper.sendGet(URI);
    }

    @Override
    public void dropAll() throws Exception {
        URI = RepoServerConfig.URL + "orders/getall";
        RequestsHelper.sendGet(URI);
    }
}
