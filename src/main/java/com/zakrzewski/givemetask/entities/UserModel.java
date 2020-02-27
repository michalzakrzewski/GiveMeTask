package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_model")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_assign_id")
    private List<TaskModel> task;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, List<TaskModel> task) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<TaskModel>  getTask() {
        return task;
    }

    public void setTask(List<TaskModel>  task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", task=" + task +
                '}';
    }
}
