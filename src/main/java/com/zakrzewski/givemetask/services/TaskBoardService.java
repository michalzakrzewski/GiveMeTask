package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.repositories.TaskBoardRepository;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import javassist.NotFoundException;
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

    public TaskBoardModel saveNewBoard(TaskBoardModel boardModel){
        return taskBoardRepository.save(boardModel);
    }

    public TaskBoardModel editTaskBoard(Long id, TaskBoardModel taskBoardModel) throws NotFoundException {
        TaskBoardModel taskBoard = taskBoardRepository.findById(id).orElseThrow(() -> new NotFoundException("Board id: " + taskBoardModel.getId() + " not found"));
        taskBoard.setBoardName(taskBoardModel.getBoardName());
        taskBoard.setTasksModelSet(taskBoardModel.getTasksModelSet());
        return taskBoardRepository.save(taskBoard);
    }

    public TaskBoardModel addTaskToBoard(Long idBoard, Long idTask) {
        Set<TaskModel> taskModelList = taskRepository.findListById(idTask);
        TaskBoardModel boardModel = taskBoardRepository.findById(idBoard).orElse(null);
        boardModel.setTasksModelSet(taskModelList);
        return taskBoardRepository.save(boardModel);
    }

    public void deleteTaskBoard(Long id){
        taskBoardRepository.deleteById(id);
    }
}
