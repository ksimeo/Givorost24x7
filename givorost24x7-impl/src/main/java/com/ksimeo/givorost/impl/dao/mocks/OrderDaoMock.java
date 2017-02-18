package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.converters.OrderConverter;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;
import com.ksimeo.givorost.core.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ksimeo. Created on 17.01.2017 at 17:33 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class OrderDaoMock implements OrderDAO {

    private List<Order> ordStorage;

    public OrderDaoMock() {
        ordStorage = new ArrayList<>(20);
        Product prod1 = new Product(1, "Біогумат для відкритого грунту", 0.97f, 3.55f);
        Product prod2 = new Product(2, "Біогумат для закритого грунту", 0.55f, 2.40f);
        ordStorage.add(new Order(1, "Алехин А.А.", "+380674567890", prod1.getName(), 98));
        ordStorage.add(new Order(2, "Курелец С.Р.", "+380934567678", prod2.getName(), 2));
        ordStorage.add(new Order(3, "Пивень Л.И.", "04434567689", prod1.getName(), 23));
        ordStorage.add(new Order(4, "Юра Хилько", "0567750544", prod1.getName(), 4));
        ordStorage.add(new Order(5, "Ярослав Прусенко", "0503456789", prod2.getName(), 6));
        ordStorage.add(new Order(6, "Ольга Крошка", "+380674567890", prod1.getName(), 98));
        ordStorage.add(new Order(7, "Игорь Крючков", "+380934567678", prod2.getName(), 2));
        ordStorage.add(new Order(8, "Паша Процько", "04434567689", prod1.getName(), 23));
        ordStorage.add(new Order(9, "Наташа Михайлова", "0567750544", prod1.getName(), 4));
        ordStorage.add(new Order(10, "Таня Кузьменко", "0503456789", prod2.getName(), 6));
        ordStorage.add(new Order(11, "Карбачин Саша", "+380674567890", prod1.getName(), 98));
        ordStorage.add(new Order(12, "Антон Чуйко", "+380934567678", prod2.getName(), 2));
        ordStorage.add(new Order(13, "Ян Аронович", "04434567689", prod1.getName(), 23));
        ordStorage.add(new Order(14, "Сергей Поляков", "0567750544", prod1.getName(), 4));
        ordStorage.add(new Order(15, "Миша Иванов", "0503456789", prod2.getName(), 6));
        ordStorage.add(new Order(16, "Женя", "+380674567890", prod1.getName(), 98));
        ordStorage.add(new Order(17, "Н.В. Шатько", "+380934567678", prod2.getName(), 2));
        ordStorage.add(new Order(18, "Сергей Гострый", "04434567689", prod1.getName(), 23));
        ordStorage.add(new Order(19, "Настя Никишкина", "0567750544", prod1.getName(), 4));
        ordStorage.add(new Order(20, "Оксана Дьяченко", "0503456789", prod2.getName(), 6));
        ordStorage.add(new Order(21, "Оксана Кондрашева", "0567750544", prod1.getName(), 4));
        ordStorage.add(new Order(22, "Лиля Прудченко", "0503456789", prod2.getName(), 6));
    }

    @Override
    public OrderDTO saveOrUpdate(OrderDTO ordDto) {
        Order order = OrderConverter.convert(ordDto);
        ordStorage.add(order);
        order.setId(ordStorage.indexOf(order) + 1);
        return OrderConverter.convert(order);
    }

    @Override
    public OrderDTO findOne(int id) {
        Order toSend = ordStorage.get(id - 1);
        return OrderConverter.convert(toSend);
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
            orders.forEach(order -> toSend.add(OrderConverter.convert(order)));
            Collections.reverse(toSend);
            return toSend;
        } else throw new IllegalArgumentException("argument \'to\' no more than argument \'to\'");
    }

    @Override
    public List<OrderDTO> findAll() {
        if (ordStorage.size() != 0) {
            List<OrderDTO> toSend = new ArrayList<>(ordStorage.size());
            ordStorage.forEach(order -> toSend.add(OrderConverter.convert(order)));
            return toSend;
        } else return null;
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