package com.zakrzewski.givemetask.repositories;

import com.zakrzewski.givemetask.entities.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    List<TaskModel> findListById(Long id);

}
