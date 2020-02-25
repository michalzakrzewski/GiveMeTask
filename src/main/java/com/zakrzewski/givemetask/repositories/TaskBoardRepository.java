package com.zakrzewski.givemetask.repositories;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBoardRepository extends JpaRepository<TaskBoardModel, Long> {
}
