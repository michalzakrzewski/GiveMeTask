package com.zakrzewski.givemetask.entities;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "work_time")
    private Long workTimeTask;

    @OneToOne()
    private UserModel user;


    public TaskModel() {
    }

    public TaskModel(String description, Long workTimeTask, UserModel user) {
        this.description = description;
        this.workTimeTask = workTimeTask;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWorkTimeTask() {
        return workTimeTask;
    }

    public void setWorkTimeTask(Long workTimeTask) {
        this.workTimeTask = workTimeTask;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
