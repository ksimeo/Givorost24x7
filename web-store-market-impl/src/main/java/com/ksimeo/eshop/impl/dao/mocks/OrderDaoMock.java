package com.ksimeo.eshop.impl.dao.mocks;

import com.ksimeo.eshop.api.dao.OrderDAO;
import com.ksimeo.eshop.entities.models.Order;
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

    private List<Order> orders;

    public OrderDaoMock() {
        orders = new ArrayList<>(20);
        orders.add(new Order(1, "Соль", "+380674567890","Александр Анатольевич", 98));
        orders.add(new Order(2, "Спички", "0934567678", "Вася", 2));
        orders.add(new Order(3, "Перец", "04434567689", "Евгений", 23));
        orders.add(new Order(4, "Сахар", "0567750544", "Максим", 4));
        orders.add(new Order(5, "Корица", "0503456789", "Дмитрий", 6));
    }

    @Override
    public Order save(Order order) {
        orders.add(order);
        order.setId(orders.indexOf(order) + 1);
        return order;
    }

    @Override
    public Order findOne(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findSeveral(int from, int to) {
        from = from - 1;
        if (from < to) {
            List<Order> toSend = null;
            if (from < orders.size()) {
                toSend = new ArrayList<>(to - from);
                for (int i = from; i < orders.size(); i++) {
                    if (i < to) {
                        toSend.add(orders.get(i));
                    } else break;
                }
            }
            return toSend;
        } else throw new IllegalArgumentException("argument \'to\' no more than argument \'to\'");
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public void dropOne(int id) {
        orders.remove(id);
    }

    @Override
    public void dropAll() {
        orders.clear();
    }

    @Override
    public int getCount() {
        return orders.size();
    }
}
