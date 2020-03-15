package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/add-new-user", method = RequestMethod.POST)
    public ResponseEntity<String> addNewUser(@RequestBody @Valid UserModel userModel){

        userService.addNewUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Add new user: '%s'", userModel.getNickName()));
    }

    @RequestMapping(value = "/{nickName}")
    public UserModel getUserByNickName(@Valid @PathVariable("nickName") String nickName){
        return userService.getUserByNickName(nickName);
    }
}
