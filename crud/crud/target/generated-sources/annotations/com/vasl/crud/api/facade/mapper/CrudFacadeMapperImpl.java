package com.vasl.crud.api.facade.mapper;

import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.dal.entity.User;
import com.vasl.crud.dal.entity.User.UserBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T02:47:09+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CrudFacadeMapperImpl implements CrudFacadeMapper {

    @Override
    public User getUserFromUserInputModel(UserInputModel userInputModel) {
        if ( userInputModel == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userInputModel.getId() );
        user.firstName( userInputModel.getFirstName() );
        user.lastName( userInputModel.getLastName() );
        user.username( userInputModel.getUsername() );

        return user.build();
    }

    @Override
    public UserOutputModel getUserOutputModelFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserOutputModel userOutputModel = new UserOutputModel();

        userOutputModel.setId( user.getId() );
        userOutputModel.setFirstName( user.getFirstName() );
        userOutputModel.setLastName( user.getLastName() );
        userOutputModel.setUsername( user.getUsername() );

        return userOutputModel;
    }

    @Override
    public List<UserOutputModel> getUsersOutputModelFromUsers(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserOutputModel> list = new ArrayList<UserOutputModel>( users.size() );
        for ( User user : users ) {
            list.add( getUserOutputModelFromUser( user ) );
        }

        return list;
    }
}
