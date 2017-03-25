package com.ksimeo.givorost.repository.dao;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.converters.OrderConverter;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.core.models.Order;
import com.ksimeo.givorost.repository.config.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OrderDao implements OrderDAO {

    @Override
    public Integer saveOrUpdate(OrderDTO order) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Order order1 = OrderConverter.convert(order);
        session.save(order1);
        session.getTransaction().commit();
        return order1.getId();
    }

    @Override
    public OrderDTO findOne(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Order res = (Order) session.load(Order.class, id);
        return OrderConverter.convert(res);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDTO> findSeveral(int f, int t) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Order> res = session.createQuery("SELECT * FROM orders LIMIT f=:f, t=:t").list();
        List<OrderDTO> toSend = new ArrayList<>(res.size());
        res.forEach(order -> toSend.add(OrderConverter.convert(order)));
        return toSend;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDTO> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Order> res = session.createCriteria(Order.class).list();
        List<OrderDTO> toSend = new ArrayList<>(res.size());
        res.forEach(order -> toSend.add(OrderConverter.convert(order)));
        return toSend;
    }

    @Override
    public void dropOne(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Order order = (Order) session.load(Order.class, id);
        session.delete(order);
        session.getTransaction().commit();
    }

    @Override
    public void dropAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.createQuery("DELETE * FROM orders");
    }

    @Override
    public int getCount() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session.createQuery("COUNT * FROM orders").executeUpdate();
    }
}