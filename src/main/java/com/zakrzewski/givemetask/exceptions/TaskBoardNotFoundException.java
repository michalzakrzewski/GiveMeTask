package com.zakrzewski.givemetask.exceptions;

public class TaskBoardNotFoundException extends RuntimeException {

    public TaskBoardNotFoundException(Long boardId) {
        super("Not found Board id: " + boardId);
    }
}
