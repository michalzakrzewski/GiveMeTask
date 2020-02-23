package com.zakrzewski.givemetask;

import com.zakrzewski.givemetask.entities.UserModel;
import com.zakrzewski.givemetask.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class GiveMeTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiveMeTaskApplication.class, args);
	}
}
