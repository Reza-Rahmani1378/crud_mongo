package com.vasl.crud.api.facade.mapper;


import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.dal.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserFacadeMapper {

    // This method is for Create the User.
    User getUserFromUserInputModel(UserInputModel userInputModel);

    // This method is for update the User.
    User getUserFromUserInputModel(@MappingTarget User user, UserInputModel userInputModel);

    UserOutputModel getUserOutputModelFromUser(User user);

    List<UserOutputModel> getUsersOutputModelFromUsers(List<User> users);
}
