package com.zakrzewski.givemetask.services;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.repositories.TaskBoardRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskBoardService {

    private final TaskBoardRepository taskBoardRepository;

    @Autowired
    public TaskBoardService(TaskBoardRepository taskBoardRepository) {
        this.taskBoardRepository = taskBoardRepository;
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
        taskBoard.setTaskList(taskBoardModel.getTaskList());
        return taskBoardRepository.save(taskBoard);
    }

    public void deleteTaskBoard(Long id, TaskBoardModel taskBoardModel){
        taskBoardRepository.deleteById(id);
    }

}
