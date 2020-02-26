package com.zakrzewski.givemetask;

import com.zakrzewski.givemetask.entities.TaskBoardModel;
import com.zakrzewski.givemetask.entities.TaskModel;
import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.repositories.UserRepository;
import com.zakrzewski.givemetask.services.TaskBoardService;
import com.zakrzewski.givemetask.services.TaskService;
import com.zakrzewski.givemetask.services.UserService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@CrossOrigin
public class GiveMeTaskApplication {

	private UserService userService;
	private TaskService taskService;
	private TaskBoardService taskBoardService;



	@Autowired
	public GiveMeTaskApplication(UserService userService, TaskService taskService, TaskBoardService taskBoardService) {
		this.userService = userService;
		this.taskService = taskService;
		this.taskBoardService = taskBoardService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GiveMeTaskApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run(){
		List<TaskModel> arrayList= new ArrayList<>();
		arrayList.add(new TaskModel("Test task1"));
		arrayList.add(new TaskModel("Test task2"));
		UserModel user1 = new UserModel("Michał", "Zakrzewski", 500L, arrayList);
		TaskBoardModel board1 = new TaskBoardModel("TODO", arrayList);

		userService.saveUser(user1);
		taskBoardService.saveNewBoard(board1);


	}
}
