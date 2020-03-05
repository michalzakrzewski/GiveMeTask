package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import com.zakrzewski.givemetask.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskModel> getAllTask(){
        return taskRepository.findAll();
    }

    public TaskModel addNewTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public TaskModel addUserToTask(Long idTask, Long idUser) throws NotFoundException {
        TaskModel task = taskRepository.findById(idTask).orElseThrow(() -> new NotFoundException("Task id not found"));
        UserModel user = userRepository.findById(idUser).orElseThrow(() -> new NotFoundException("User not found"));
        task.setUser(user);
        return taskRepository.save(task);

    }

}
