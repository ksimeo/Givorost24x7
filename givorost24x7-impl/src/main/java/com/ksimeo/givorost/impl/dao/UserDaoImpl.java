package com.ksimeo.givorost.impl.dao;

import com.ksimeo.givorost.api.dao.UserDAO;
import com.ksimeo.givorost.core.dto.UserDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:13 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
//@Repository
public class UserDaoImpl implements UserDAO {

    @Override
    public UserDTO saveOrUpdate(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findOne(int id) {
        return null;
    }

    @Override
    public UserDTO findOne(String login, String password) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public void dropOne(int id) {

    }

    @Override
    public void dropAll() {

    }
}
