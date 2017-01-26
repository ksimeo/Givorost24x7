package com.ksimeo.givorost.core.dto;

/**
 * @author Ksimeo. Created on 12.01.2017 at 16:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class UserDTO {
    private String login;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
