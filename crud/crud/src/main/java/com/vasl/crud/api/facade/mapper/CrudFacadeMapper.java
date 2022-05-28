package com.vasl.crud.api.facade.mapper;


import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.dal.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CrudFacadeMapper {

    User getUserFromUserInputModel(UserInputModel userInputModel);

    UserOutputModel getUserOutputModelFromUser(User user);

    List<UserOutputModel> getUsersOutputModelFromUsers(List<User> users);
}
