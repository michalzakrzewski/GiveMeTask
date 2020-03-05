package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.exceptions.TaskBoardNotFoundException;
import com.zakrzewski.givemetask.exceptions.TaskNotFoundException;
import com.zakrzewski.givemetask.repositories.TaskBoardRepository;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public TaskBoardModel getOneTaskBoard(Long boardId){
        return taskBoardRepository.findById(boardId).orElseThrow(() -> new TaskBoardNotFoundException(boardId));
    }

    public TaskBoardModel saveNewBoard(TaskBoardModel boardModel){
        return taskBoardRepository.save(boardModel);
    }

    public TaskBoardModel editTaskBoard(Long taskId, TaskBoardModel taskBoardModel) {
        TaskBoardModel taskBoard = taskBoardRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        taskBoard.setBoardName(taskBoardModel.getBoardName());
        taskBoard.setTasksModelList(taskBoardModel.getTasksModelList());
        return taskBoardRepository.save(taskBoard);
    }

    public TaskBoardModel addTaskToBoard(Long idBoard, Long idTask) {
        TaskModel task = taskRepository.findById(idTask).orElseThrow(() -> new TaskNotFoundException(idTask));
        TaskBoardModel board = taskBoardRepository.findById(idBoard).orElseThrow(() -> new TaskBoardNotFoundException(idBoard));
        Set<TaskModel> tasksModelList = board.getTasksModelList();
        tasksModelList.add(task);
        board.setTasksModelList(tasksModelList);
        return taskBoardRepository.save(board);
    }

    public void deleteTaskBoard(Long id){
        try {
            taskBoardRepository.deleteById(id);
        }catch (TaskBoardNotFoundException ex){
            ex.getMessage();
        }

    }
}
