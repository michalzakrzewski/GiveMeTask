package com.zakrzewski.givemetask.exceptions;

public class TaskBoardNotFoundException extends RuntimeException {

    public TaskBoardNotFoundException(Long boardId) {
        super("Could not find Board id: " + boardId);
    }
}
