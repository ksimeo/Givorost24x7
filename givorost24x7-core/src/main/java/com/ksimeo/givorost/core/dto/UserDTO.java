package com.ksimeo.givorost.core.dto;

/**
 * @author Ksimeo. Created on 12.01.2017 at 16:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private boolean isAdmin;


    public UserDTO() {
    }

    public UserDTO(String login, String password, String name, String surname, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
