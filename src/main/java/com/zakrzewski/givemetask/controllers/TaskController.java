package com.zakrzewski.givemetask.controllers;

import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskModel> getAllTasks(){
        return taskService.getAllTask();
    }

    @RequestMapping(value = "/add-task", method = RequestMethod.POST)
    public ResponseEntity<String> addNewTask(@RequestBody TaskModel taskModel){
        taskService.addNewTask(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Task '%s' created", taskModel.getDescription()));
    }
}
