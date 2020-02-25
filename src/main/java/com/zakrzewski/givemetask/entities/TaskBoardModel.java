package com.zakrzewski.givemetask.entities;

import javax.persistence.*;

@Entity
@Table(name = "task_board")
public class TaskBoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_name")
    private String boardName;

    public TaskBoardModel() {
    }

    public TaskBoardModel(Long id, String boardName) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TaskBoardModel{" +
                "id=" + id +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
