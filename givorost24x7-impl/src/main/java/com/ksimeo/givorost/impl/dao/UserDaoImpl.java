package com.ksimeo.givorost.impl.dao;

import com.ksimeo.givorost.api.dao.UserDAO;
import com.ksimeo.givorost.core.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:13 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
//@Repository
public class UserDaoImpl implements UserDAO {

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public User findOne(String login, String password) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
