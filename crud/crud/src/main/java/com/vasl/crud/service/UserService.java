package com.vasl.crud.service;

import com.vasl.crud.dal.entity.User;

import java.util.List;

public interface UserService {

    // Create the user
    User add(User user);

    // Read the user
    User getUserByUsername(String username);

    List<User> getAll();

    void deleteUser(String username);

    Boolean existUserByUsername(String username);
}
