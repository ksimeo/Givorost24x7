package com.ksimeo.eshop.impl.dao.mocks;

import com.ksimeo.eshop.api.dao.UserDAO;
import com.ksimeo.eshop.entities.models.Role;
import com.ksimeo.eshop.entities.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:20 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class UserDaoMock implements UserDAO {

    private List<User> users;


    public UserDaoMock() {
        users = new ArrayList<User>(4);
        users.add(new User("vasya", "123max", "Вася", "Пупкин", Role.USER));
        users.add(new User("kolya", "12345", "Коля", "Ласточкин", Role.ADMIN));
        users.add(new User("senya", "sdfsdgf", "Сеня", "Петров", Role.USER));
        users.add(new User("petya", "sdsgg12", "Петя", "Николаев", Role.ADMIN));
    }

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public User findOne(String login, String password) {
        if (login.equalsIgnoreCase("vasya") && password.equals("123max"))
            return new User("vasya", "123max", "Вася", "Пупкин", Role.USER);
        else return null;
    }


    public List<User> findAll() {
        return users;
    }
}