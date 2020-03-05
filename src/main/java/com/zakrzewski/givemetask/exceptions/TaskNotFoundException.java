package com.zakrzewski.givemetask.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long taskId) {
        super("Task not found id: " + taskId);
    }
}
