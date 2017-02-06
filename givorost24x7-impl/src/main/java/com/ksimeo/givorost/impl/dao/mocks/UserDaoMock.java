package com.ksimeo.givorost.impl.dao.mocks;

import com.ksimeo.givorost.api.dao.UserDAO;
import com.ksimeo.givorost.core.dto.UserDTO;
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

    private List<UserDTO> users;


    public UserDaoMock() {
        users = new ArrayList<>(4);
        users.add(new UserDTO("vasya", "123max", "Вася", "Пупкин", false));
        users.add(new UserDTO("kolya", "12345", "Коля", "Ласточкин", true));
        users.add(new UserDTO("senya", "sdfsdgf", "Сеня", "Петров", false));
        users.add(new UserDTO("petya", "sdsgg12", "Петя", "Николаев", true));
    }

    @Override
    public UserDTO findOne(int id) {
        return null;
    }

    @Override
    public UserDTO findOne(String login, String password) {
        if (login.equalsIgnoreCase("vasya") && password.equals("123max"))
            return new UserDTO("vasya", "123max", "Вася", "Пупкин", false);
        else return null;
    }


    public List<UserDTO> findAll() {
        return users;
    }

    @Override
    public UserDTO saveOrUpdate(UserDTO userDTO) {
        users.add(userDTO);
        userDTO.setId(users.indexOf(userDTO) + 1);
        return userDTO;
    }

    @Override
    public void dropOne(int id) {
        users.remove(id - 1);
    }

    @Override
    public void dropAll() {
        users.clear();
    }
}