package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.converters.OrderConverter;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;
import com.ksimeo.givorost.core.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 17:33 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class OrderDaoMock implements OrderDAO {

    private List<Order> ordStorage;
    private OrderConverter converter;

    public OrderDaoMock() {
        ordStorage = new ArrayList<>(20);
        Product prod1 = new Product(1, "Біогумат для відкритого грунту", 0.97f, 3.55f);
        Product prod2 = new Product(2, "Біогумат для закритого грунту", 0.55f, 2.40f);
        ordStorage.add(new Order(1, "Александр Анатольевич", "+380674567890", prod1, 98));
        ordStorage.add(new Order(2, "Вася", "+380934567678", prod2, 2));
        ordStorage.add(new Order(3, "Евгений", "04434567689", prod1, 23));
        ordStorage.add(new Order(4, "Максим", "0567750544", prod1, 4));
        ordStorage.add(new Order(5, "Дмитрий", "0503456789", prod2, 6));
    }

    @Override
    public OrderDTO saveOrUpdate(OrderDTO ordDto) {
        Order order = converter.convert(ordDto);
        ordStorage.add(order);
        order.setId(ordStorage.indexOf(order) + 1);
        return converter.convert(order);
    }

    @Override
    public OrderDTO findOne(int id) {
        Order toSend = ordStorage.get(id - 1);
        return converter.convert(toSend);
    }

    @Override
    public List<OrderDTO> findSeveral(int from, int to) {
        from = from - 1;
        if (from < to) {
            List<Order> orders = null;
            if (from < ordStorage.size()) {
                orders = new ArrayList<>(to - from);
                for (int i = from; i < ordStorage.size(); i++) {
                    if (i < to) {
                        orders.add(ordStorage.get(i));
                    } else break;
                }
            }
            List<OrderDTO> toSend = new ArrayList<>(orders.size());
            orders.forEach(order -> toSend.add(converter.convert(order)));
            return toSend;
        } else throw new IllegalArgumentException("argument \'to\' no more than argument \'to\'");
    }

    @Override
    public List<OrderDTO> findAll() {
        List<OrderDTO> toSend = new ArrayList<>(ordStorage.size());
        ordStorage.forEach(order -> toSend.add(converter.convert(order)));
        return toSend;
    }

    @Override
    public void dropOne(int id) {
        ordStorage.remove(id);
    }

    @Override
    public void dropAll() {
        ordStorage.clear();
    }

    @Override
    public int getCount() {
        return ordStorage.size();
    }
}
