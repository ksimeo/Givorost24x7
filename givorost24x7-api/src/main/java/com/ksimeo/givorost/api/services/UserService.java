package com.ksimeo.givorost.api.services;

import com.ksimeo.givorost.core.dto.UserDTO;

import java.util.List;

/**
 * @author Ksimeo. Created on 16.01.2017 at 14:08 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    UserDTO getOneByLoginPassword(String login, String password);
    List<UserDTO> getAll();
}
