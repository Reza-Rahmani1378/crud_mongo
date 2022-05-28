package com.vasl.crud.api.controller;

import com.vasl.crud.api.dto.UserInputModel;
import com.vasl.crud.api.dto.UserOutputModel;
import com.vasl.crud.api.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*
 * در این قسمت باید ابتدا نام api آورده شود و سپس ورژن آن پروژه ای که ما داریم روی آن کار میکنیم و سپس بعد از آن لازم است که نام مایکروسرویسی که با
 * آن کار میکنیم وارد می شود و سپس نام کنترلری که داریم با آن کار میکنیم وارد می شود.
 * */
@RequestMapping("/api/v1/fs/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    // save user
    @PostMapping
    public UserOutputModel addUser(@RequestBody UserInputModel userInputModel) {
        return userFacade.add(userInputModel);
    }

    // update user
    @PutMapping("{id}")
    public UserOutputModel updateUser(@PathVariable("id") String id, @RequestBody UserInputModel userInputModel) {
        return userFacade.update(id, userInputModel);
    }

    // Delete user
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        userFacade.deleteUserById(id);
    }

    // getAll Users
    @GetMapping
    public List<UserOutputModel> getAllUsers() {
        return userFacade.getUsers();
    }

    // get User By username
    @GetMapping("/username/{username}")
    public UserOutputModel getUserByUsername(@PathVariable("username") String username) {
        return userFacade.getUser(username);
    }


}
