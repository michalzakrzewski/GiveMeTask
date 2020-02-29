package com.zakrzewski.givemetask.repositories;

import com.zakrzewski.givemetask.entities.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    Set<TaskModel> findListById(Long id);

}
