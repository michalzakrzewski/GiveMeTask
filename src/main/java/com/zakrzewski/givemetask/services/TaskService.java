package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getAllTask(){
        return taskRepository.findAll();
    }

    public TaskModel addNewTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }
}
