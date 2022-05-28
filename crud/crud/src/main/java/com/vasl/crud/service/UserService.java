package com.vasl.crud.service;

import com.vasl.crud.dal.entity.User;

import java.util.List;

public interface UserService {

    // Create the user
    User add(User user);

    void update(User user);

    // Read the user
    User findUserById(String id);

    List<User> getAll();

    void deleteUserById(String id);

    Boolean existUserByUsername(String username);

    User getUserByUsername(String username);
}
