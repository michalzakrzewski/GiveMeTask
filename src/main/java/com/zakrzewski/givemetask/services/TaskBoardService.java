package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.repositories.TaskBoardRepository;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import javafx.concurrent.Task;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class TaskBoardService {

    private final TaskBoardRepository taskBoardRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskBoardService(TaskBoardRepository taskBoardRepository, TaskRepository taskRepository) {
        this.taskBoardRepository = taskBoardRepository;
        this.taskRepository = taskRepository;
    }

    public List<TaskBoardModel> getAllTaskBoards(){
        return taskBoardRepository.findAll();
    }

    public TaskBoardModel saveNewBoard(TaskBoardModel boardModel){
        return taskBoardRepository.save(boardModel);
    }

    public TaskBoardModel editTaskBoard(Long id, TaskBoardModel taskBoardModel) throws NotFoundException {
        TaskBoardModel taskBoard = taskBoardRepository.findById(id).orElseThrow(() -> new NotFoundException("Board id: " + taskBoardModel.getId() + " not found"));
        taskBoard.setBoardName(taskBoardModel.getBoardName());
        taskBoard.setTasksModelList(taskBoardModel.getTasksModelList());
        return taskBoardRepository.save(taskBoard);
    }

    public TaskBoardModel addTaskToBoard(Long idBoard, Long idTask) throws NotFoundException {
        TaskModel task = taskRepository.findById(idTask).orElseThrow(() -> new NotFoundException("Task not found, id: " + idTask));
        TaskBoardModel board = taskBoardRepository.findById(idBoard).orElseThrow(() -> new NotFoundException("Board not found, id: " + idTask));
        Set<TaskModel> tasksModelList = board.getTasksModelList();
        tasksModelList.add(task);
        board.setTasksModelList(tasksModelList);
        return taskBoardRepository.save(board);
    }

    public void deleteTaskBoard(Long id){
        taskBoardRepository.deleteById(id);
    }
}
