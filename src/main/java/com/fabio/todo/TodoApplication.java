package com.fabio.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabio.todo.Repositories.TodoRepository;
import com.fabio.todo.domain.todo;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		todo t1 = new todo(null,"Estudar", "Estudar Spring Boot 2", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
		todoRepository.saveAll(Arrays.asList(t1));
	}

}
