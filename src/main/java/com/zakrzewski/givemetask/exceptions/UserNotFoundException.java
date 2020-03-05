package com.zakrzewski.givemetask.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long idUser) {
        super("Could not found User id: " + idUser);
    }
}
