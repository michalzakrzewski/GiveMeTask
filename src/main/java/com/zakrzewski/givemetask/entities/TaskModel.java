package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
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

    @OneToOne()
    private UserModel assignedTo;




    public TaskModel() {
    }

    public TaskModel(String description, Long workTimeTask, UserModel assignedTo) {
        this.description = description;
        this.workTimeTask = workTimeTask;
        this.assignedTo = assignedTo;
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


    public UserModel getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserModel user) {
        this.assignedTo = user;
    }
}
