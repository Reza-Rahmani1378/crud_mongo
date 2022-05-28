package com.vasl.crud.api.facade;

import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.api.facade.mapper.UserFacadeMapper;
import com.vasl.crud.dal.entity.User;
import com.vasl.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserFacadeMapper userFacadeMapper;

    public UserOutputModel add(UserInputModel userInputModel) {
        User user = userFacadeMapper.getUserFromUserInputModel(userInputModel);
        user = userService.add(user);
        return userFacadeMapper.getUserOutputModelFromUser(user);
    }

    public UserOutputModel update(String id, UserInputModel userInputModel) {

        User user = userService.findUserById(id);
        userFacadeMapper.getUserFromUserInputModel(user, userInputModel);
        userService.update(user);
        return userFacadeMapper.getUserOutputModelFromUser(user);
    }

    public void deleteUserById(String id) {
        userService.deleteUserById(id);
    }

    public UserOutputModel getUser(String username) {
        User user = userService.getUserByUsername(username);
        return userFacadeMapper.getUserOutputModelFromUser(user);
    }

    public List<UserOutputModel> getUsers() {
        List<User> users = userService.getAll();
        return userFacadeMapper.getUsersOutputModelFromUsers(users);
    }


}
