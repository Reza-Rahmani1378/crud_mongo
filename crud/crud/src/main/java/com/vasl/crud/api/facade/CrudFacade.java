package com.vasl.crud.api.facade;

import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.api.facade.mapper.CrudFacadeMapper;
import com.vasl.crud.dal.entity.User;
import com.vasl.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CrudFacade {

    private final UserService userService;
    private final CrudFacadeMapper crudFacadeMapper;

    public UserOutputModel add(UserInputModel userInputModel) {
        String username = userInputModel.getUsername();
        if (userService.existUserByUsername(username)) {
            User user = userService.getUserByUsername(username);
            userInputModel.setId(user.getId());
            user = crudFacadeMapper.getUserFromUserInputModel(userInputModel);
            user = userService.add(user);
            return crudFacadeMapper.getUserOutputModelFromUser(user);
        }
        User user = crudFacadeMapper.getUserFromUserInputModel(userInputModel);
        user = userService.add(user);
        return crudFacadeMapper.getUserOutputModelFromUser(user);
    }

    public void deleteUserByUsername(String username) {
        userService.deleteUser(username);
    }

    public UserOutputModel getUser(String username) {
        User user = userService.getUserByUsername(username);
        return crudFacadeMapper.getUserOutputModelFromUser(user);
    }

    public List<UserOutputModel> getUsers() {
        List<User> users = userService.getAll();
        return crudFacadeMapper.getUsersOutputModelFromUsers(users);
    }


}
