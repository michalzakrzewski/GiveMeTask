package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.services.TaskBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/add-board", method = RequestMethod.POST)
    public ResponseEntity<String> saveNewBoard(@RequestBody TaskBoardModel boardModel){
        taskBoardService.saveNewBoard(boardModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Board '%s' created", boardModel.getBoardName()));
    }
}
