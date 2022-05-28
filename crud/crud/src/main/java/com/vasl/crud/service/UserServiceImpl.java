package com.vasl.crud.service;

import com.vasl.crud.dal.entity.User;
import com.vasl.crud.dal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public void deleteUser(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public Boolean existUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }
}
