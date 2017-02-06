package com.ksimeo.givorost.core.converters;

import com.ksimeo.givorost.core.dto.UserDTO;
import com.ksimeo.givorost.core.models.User;

/**
 * @author Ksimeo. Created on 01.02.2017 at 21:27 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class UserConverter {

    private UserConverter() {
    }

    public static User convert(UserDTO userDTO) {
        User toSend = new User();
        toSend.setName(userDTO.getName());
        toSend.setSurname(userDTO.getSurname());
        toSend.setLogin(userDTO.getLogin());
        toSend.setPassword(userDTO.getPassword());
        toSend.setIsAdmin(userDTO.isAdmin());
        return toSend;
    }

    public static UserDTO convert(User user) {
        UserDTO toSend = new UserDTO();
        toSend.setName(user.getName());
        toSend.setSurname(user.getSurname());
        toSend.setLogin(user.getLogin());
        toSend.setPassword(user.getPassword());
        toSend.setIsAdmin(user.isAdmin());
        return toSend;
    }
}
