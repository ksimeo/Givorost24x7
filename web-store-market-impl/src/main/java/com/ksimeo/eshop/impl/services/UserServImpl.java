package com.ksimeo.eshop.impl.services;

import com.ksimeo.eshop.api.dao.UserDAO;
import com.ksimeo.eshop.api.services.UserService;
import com.ksimeo.eshop.entities.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 13:46 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServImpl implements UserService {
    @Autowired
    private UserDAO usrDao;

    public User getOneByLoginPassword(String login, String password) {
        return usrDao.findOne(login, password);
    }

    public List<User> getAll() {
        return usrDao.findAll();
    }
}
