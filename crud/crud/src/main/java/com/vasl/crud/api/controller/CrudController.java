package com.vasl.crud.api.controller;

import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.api.facade.CrudFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class CrudController {

    private final CrudFacade crudFacade;

    // save user
    @PostMapping("/saveUser")
    public UserOutputModel addUser(@RequestBody UserInputModel userInputModel) {
        return crudFacade.add(userInputModel);
    }

    // update user
    @PutMapping("/updateUser")
    public UserOutputModel updateUser(@RequestBody UserInputModel userInputModel) {
        return crudFacade.add(userInputModel);
    }

    // Delete user
    @DeleteMapping("/deleteUser/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        crudFacade.deleteUserByUsername(username);
    }

    // getAll Users
    @GetMapping("/users")
    public List<UserOutputModel> getAllUsers() {
        return crudFacade.getUsers();
    }

    // get User By username
    @GetMapping("/getUser/{username}")
    public UserOutputModel getUserByUsername(@PathVariable("username") String username) {
        return crudFacade.getUser(username);
    }


}
