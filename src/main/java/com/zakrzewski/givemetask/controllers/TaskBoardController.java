package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.services.TaskBoardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/boards")
public class TaskBoardController {

    private final TaskBoardService taskBoardService;

    @Autowired
    public TaskBoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskBoardModel> getAllTaskBoards(){
        return taskBoardService.getAllTaskBoards();
    }

    @RequestMapping(value = "/add-board", method = RequestMethod.POST)
    public ResponseEntity<String> saveNewBoard(@RequestBody TaskBoardModel boardModel){
        taskBoardService.saveNewBoard(boardModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Board '%s' created", boardModel.getBoardName()));
    }

    @RequestMapping(value = "/get-one/{boardId}", method = RequestMethod.GET)
    public TaskBoardModel getOneById(@PathVariable("boardId") Long boardId){
        return taskBoardService.getOneTaskBoard(boardId);
    }

    @RequestMapping(value = "/edit-board/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editTaskBoard(@PathVariable(value = "id") Long id, @Valid @RequestBody TaskBoardModel taskBoardModel) {
        taskBoardService.editTaskBoard(id, taskBoardModel);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Board '%s' updated", taskBoardModel.getBoardName()));
    }


    @RequestMapping(value = "/delete-board/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTaskBoard(@PathVariable(value = "id") Long id){
        taskBoardService.deleteTaskBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Task Board '%s' deleted", id));
    }

    @RequestMapping(value = "/{idBoard}/task/{idTask}", method = RequestMethod.PUT)
    public ResponseEntity<String> addTasksToBoard(@PathVariable(value = "idBoard") Long idBoard, @PathVariable(value = "idTask") Long idTask) throws NotFoundException {
        taskBoardService.addTaskToBoard(idBoard, idTask);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("To board '%s', add task '%s'", idBoard, idTask));
    }
}
