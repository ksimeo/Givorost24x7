package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.converters.OrderConverter;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;
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
        ordStorage.add(new Order(1, "Соль", "+380674567890", "Александр Анатольевич", 98));
        ordStorage.add(new Order(2, "Спички", "0934567678", "Вася", 2));
        ordStorage.add(new Order(3, "Перец", "04434567689", "Евгений", 23));
        ordStorage.add(new Order(4, "Сахар", "0567750544", "Максим", 4));
        ordStorage.add(new Order(5, "Корица", "0503456789", "Дмитрий", 6));
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
