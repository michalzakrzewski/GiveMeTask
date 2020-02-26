package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel saveUser(UserModel newUser){
        return userRepository.save(newUser);
    }
}
