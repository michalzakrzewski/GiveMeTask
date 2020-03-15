package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "create_task_date_time")
    private LocalDateTime createTaskDateTime;

    @Column(name = "start_task_date_time")
    private LocalDateTime startTaskDateTime;

    @Column(name = "end_task_date_time")
    private LocalDateTime endTaskDateTime;

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

    public LocalDateTime getCreateTaskDateTime() {
        return createTaskDateTime;
    }

    public void setCreateTaskDateTime(LocalDateTime createTaskDateTime) {
        this.createTaskDateTime = createTaskDateTime;
    }

    public LocalDateTime getStartTaskDateTime() {
        return startTaskDateTime;
    }

    public void setStartTaskDateTime(LocalDateTime startTaskDateTime) {
        this.startTaskDateTime = startTaskDateTime;
    }

    public LocalDateTime getEndTaskDateTime() {
        return endTaskDateTime;
    }

    public void setEndTaskDateTime(LocalDateTime endTaskDateTime) {
        this.endTaskDateTime = endTaskDateTime;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
