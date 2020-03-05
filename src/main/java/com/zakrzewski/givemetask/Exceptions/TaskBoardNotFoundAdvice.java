package com.zakrzewski.givemetask.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaskBoardNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TaskBoardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String taskBoardNotFoundHandler(TaskBoardNotFoundException ex){
        return ex.getMessage();
    }
}
