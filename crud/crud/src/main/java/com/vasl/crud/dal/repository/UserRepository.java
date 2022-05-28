package com.vasl.crud.dal.repository;

import com.vasl.crud.dal.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Get User By Username
    User getUserByUsername(String username);

    void deleteUserByUsername(String username);

    Boolean existsUserByUsername(String username);

}
