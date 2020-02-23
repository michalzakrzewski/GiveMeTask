package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserModel userModel){
        userService.saveUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("User '%s' created", userModel.getFirstName()));
    }
}
