package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.services.TaskBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/boards")
public class TaskBoardController {

    private final TaskBoardService taskBoardService;

    @Autowired
    public TaskBoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TaskBoardModel> getAllTaskBoards(){
        return taskBoardService.getAllTaskBoards();
    }
}
