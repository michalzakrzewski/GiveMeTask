package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task_boards")
public class TaskBoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_name")
    private String boardName;

    @OneToMany
    @JoinColumn(name = "board_tasks_id")
    private List<TaskModel> tasksModelList;

    public TaskBoardModel() {
    }

    public TaskBoardModel(String boardName) {
        this.boardName = boardName;
    }

    public TaskBoardModel(String boardName, List<TaskModel> tasksModelList) {
        this.boardName = boardName;
        this.tasksModelList = tasksModelList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<TaskModel> getTasksModelList() {
        return tasksModelList;
    }

    public void setTasksModelList(List<TaskModel> tasksModelList) {
        this.tasksModelList = tasksModelList;
    }
}
