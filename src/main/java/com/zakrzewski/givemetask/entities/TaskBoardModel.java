package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
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
    private Set<TaskModel> tasksModelSet;

    public TaskBoardModel() {
    }

    public TaskBoardModel(String boardName) {
        this.boardName = boardName;
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

    public Set<TaskModel> getTasksModelSet() {
        return tasksModelSet;
    }

    public void setTasksModelSet(Set<TaskModel> tasksModelSet) {
        this.tasksModelSet = tasksModelSet;
    }
}
