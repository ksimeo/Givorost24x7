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
public class OrderServerImpl implements OrderService {

    public static final int rowCount = 5;
    public static final int maxPagesPaginNumb = 5;

    private int minPageNumb;
    private int maxPageNumb;

    private String URI;
    private String echoData;
    private ObjectMapper mapper;

    @Autowired
    private OrderDAO ordDao;

    public OrderServerImpl() {
        mapper = new ObjectMapper();
    }

    @Override
    public List<OrderDTO> getAll() throws Exception {
        echoData = RequestsHelper.sendGet(RepoServerConfig.URL + "getallordrs");
        return mapper.readValue(echoData, new TypeReference<List<OrderDTO>>(){ });
    }

    @Override
    public OrderPage getPage(int pageNumb) throws Exception {
//        int from;
//        int to;
//        boolean isLastPage = false;
        int numb = ordDao.getCount();
//        int maxFullPage = numb / rowCount;
//        if (pageNumb > maxFullPage) {
//            pageNumb = maxFullPage;
//            isLastPage = true;
//        }
//        if (pageNumb > 0) {
//            to = numb - ((pageNumb - 1) * rowCount);
//            from = to - (rowCount - 1);
//        } else {
//            pageNumb = 1;
//            to = numb - ((pageNumb - 1) * rowCount);
//            from = to - (rowCount - 1);
//        }
        PagesHelper.PageInfo pageInfo = PagesHelper.getRowNumbers(pageNumb, numb, rowCount);
        int from = pageInfo.from;
        int to = pageInfo.to;
        boolean isLastPage = pageInfo.isLast;
        int maxFullPage = PagesHelper.getPageCount(numb, rowCount);
        URI = RepoServerConfig.URL + "getorders/" + from + "/" + to;
        echoData = RequestsHelper.sendGet(URI);
        List<OrderDTO> toSend = mapper.readValue(echoData, new TypeReference<List<OrderDTO>>() { });
        URI = RepoServerConfig.URL + "getordrscount";
        echoData = RequestsHelper.sendGet(URI);
        int count = Integer.parseInt(echoData);
        List<String> pagination = PagesHelper.getPagination(pageNumb, count, maxPagesPaginNumb);
        return new OrderPage(toSend, maxFullPage, isLastPage, pagination);
    }

    @Override
    public OrderDTO getOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "getorder/" + id;
        echoData = RequestsHelper.sendGet(URI);
        return mapper.readValue(echoData, OrderDTO.class);
    }

    @Override
    public OrderDTO addOne(OrderDTO order) throws Exception {
        System.err.println("Отправляемый объект: " + order);
        URI = RepoServerConfig.URL + "addorder";
        String data = mapper.writeValueAsString(order);
        System.err.println("Отправляемые данные: " + data);
        echoData = RequestsHelper.sendPost(URI, data);
        return mapper.readValue(echoData, OrderDTO.class);
    }

    @Override
    public void dropOne(int id) throws Exception {
        URI = RepoServerConfig.URL + "delorder/" + id;
        RequestsHelper.sendGet(URI);
    }

    @Override
    public void dropAll() {

    }
}
