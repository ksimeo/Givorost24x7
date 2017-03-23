package com.ksimeo.givorost.repository.dao;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.converters.ProductConverter;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.core.models.Product;
import com.ksimeo.givorost.repository.config.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductDAO {

    @Override
    public int saveOrUpdate(ProductDTO prod) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = ProductConverter.convert(prod);
        session.save(product);
        session.getTransaction().commit();
        return prod.getId();
    }

    @Override
    public ProductDTO findOne(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Product prod = (Product) session.load(Product.class, id);
        ProductDTO prodDTO = ProductConverter.convert(prod);
        return prodDTO;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProductDTO> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Product> res = session.createCriteria(Product.class).list();
        List<ProductDTO> toSend = new ArrayList<>(res.size());
        res.forEach(prod -> toSend.add(ProductConverter.convert(prod)));
        return toSend;
    }

    @Override
    public void dropOne(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product prod = (Product) session.load(Product.class, id);
        session.delete(prod);
        session.getTransaction().commit();
    }

    @Override
    public void dropAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.createQuery("DELETE * FROM products");
    }
}