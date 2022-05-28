package com.vasl.crud.service;

import com.vasl.crud.dal.entity.User;
import com.vasl.crud.dal.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    @Override
    public User add(User user) {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new Exception("Duplicated Added User Please Try Again.");
        }

        return userRepository.insert(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @SneakyThrows
    public User findUserById(String id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("User By This id not found.");
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean existUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
