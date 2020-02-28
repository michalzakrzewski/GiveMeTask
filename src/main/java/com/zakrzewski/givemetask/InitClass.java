package com.zakrzewski.givemetask;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.repositories.TaskBoardRepository;
import com.zakrzewski.givemetask.repositories.TaskRepository;
import com.zakrzewski.givemetask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InitClass {

    @Autowired
    public InitClass(TaskRepository taskRepository, UserRepository userRepository, TaskBoardRepository taskBoardRepository){

        TaskBoardModel board1 = new TaskBoardModel("TODO");
        TaskBoardModel board2 = new TaskBoardModel("In Progress");
        TaskBoardModel board3 = new TaskBoardModel("Done");

        TaskModel task1 = new TaskModel("Create new view", 120L);
        TaskModel task2 = new TaskModel("Create new entity", 60L);
        TaskModel task3 = new TaskModel("Tests", 90L);

        UserModel user1 = new UserModel("Andrzej", "Kiełek");
        UserModel user2 = new UserModel("Zuzanna", "Lasik");
        UserModel user3 = new UserModel("Michał", "Zakrzewski");

        Set<TaskModel> taskModelSet1 = Stream.of(task1, task2, task3).collect(Collectors.toSet());
        Set<TaskModel> taskModelSet2 = Stream.of(task2, task3).collect(Collectors.toSet());
        Set<TaskModel> taskModelSet3 = Stream.of(task1, task3).collect(Collectors.toSet());

        board1.setTasksModelSet(taskModelSet1);
        board2.setTasksModelSet(taskModelSet2);
        board3.setTasksModelSet(taskModelSet3);

        user1.setTasksModelSet(taskModelSet1);
        user2.setTasksModelSet(taskModelSet2);
        user3.setTasksModelSet(taskModelSet3);

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        taskBoardRepository.save(board1);
        taskBoardRepository.save(board2);
        taskBoardRepository.save(board3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);







    }
}
