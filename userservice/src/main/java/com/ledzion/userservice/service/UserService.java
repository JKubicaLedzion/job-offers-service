package com.ledzion.userservice.service;

import com.ledzion.userservice.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String login);

    User getUser(String login);

    List<User> getUsers();
}
