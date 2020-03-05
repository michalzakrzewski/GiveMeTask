package com.zakrzewski.givemetask.Exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long taskId) {
    }
}
