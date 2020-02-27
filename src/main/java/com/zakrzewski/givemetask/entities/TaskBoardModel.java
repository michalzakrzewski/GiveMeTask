package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_board")
public class TaskBoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_name")
    private String boardName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_assign_id")
    private List<TaskModel> taskList;

    public TaskBoardModel() {
    }

    public TaskBoardModel(String boardName){
        this.boardName = boardName;
    }

    public TaskBoardModel(String boardName, List<TaskModel> taskList) {
        this.boardName = boardName;
        this.taskList = taskList;
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

    public List<TaskModel> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "TaskBoardModel{" +
                "id=" + id +
                ", boardName='" + boardName + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
