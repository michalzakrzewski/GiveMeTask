package com.zakrzewski.givemetask.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany()
    @JoinColumn(name = "user_tasks_id")
    private Set<TaskModel> tasksModelSet;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<TaskModel> getTasksModelSet() {
        return tasksModelSet;
    }

    public void setTasksModelSet(Set<TaskModel> tasksModelSet) {
        this.tasksModelSet = tasksModelSet;
    }
}
