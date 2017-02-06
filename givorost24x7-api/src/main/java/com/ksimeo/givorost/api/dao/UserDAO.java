package com.ksimeo.givorost.api.dao;

import com.ksimeo.givorost.core.dto.UserDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:12 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDAO {

    UserDTO saveOrUpdate(UserDTO userDTO);
    UserDTO findOne(int id);
    UserDTO findOne(String login, String password);
    List<UserDTO> findAll();
    void dropOne(int id);
    void dropAll();
}
