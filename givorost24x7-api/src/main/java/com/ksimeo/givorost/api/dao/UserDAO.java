package com.ksimeo.givorost.api.dao;

import com.ksimeo.givorost.core.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:12 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDAO {

    User findOne(int id);
    User findOne(String login, String password);
    List<User> findAll();
}
