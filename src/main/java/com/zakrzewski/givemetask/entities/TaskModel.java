package com.zakrzewski.givemetask.entities;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "work_time")
    private Long workTimeTask;

    public TaskModel() {
    }

    public TaskModel(String description){
        this.description = description;
        this.workTimeTask = 0L;
    }

    public TaskModel(String description, Long workTimeTask) {
        this.description = description;
        this.workTimeTask = workTimeTask;
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

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", workTimeTask=" + workTimeTask +
                '}';
    }
}
