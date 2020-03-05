package com.zakrzewski.givemetask.Exceptions;

public class TaskBoardNotFoundException extends RuntimeException {

    public TaskBoardNotFoundException(Long taskId) {
        super("Could not find Board id: " + taskId);
    }
}
