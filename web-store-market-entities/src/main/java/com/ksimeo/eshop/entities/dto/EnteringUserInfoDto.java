package com.ksimeo.eshop.entities.dto;

/**
 * @author Ksimeo. Created on 12.01.2017 at 16:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class EnteringUserInfoDto {
    private String login;
    private String password;

    public EnteringUserInfoDto() {
    }

    public EnteringUserInfoDto(String login, String password) {
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
