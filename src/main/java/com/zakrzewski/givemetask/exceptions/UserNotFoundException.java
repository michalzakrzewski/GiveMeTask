package com.zakrzewski.givemetask.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long idUser) {
        super("Not found User id: " + idUser);
    }
}
