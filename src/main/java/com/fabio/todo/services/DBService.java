package com.fabio.todo.services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.todo.Repositories.TodoRepository;
import com.fabio.todo.domain.todo;


@Service
public class DBService {


    @Autowired
	private TodoRepository todoRepository;
  

    
    public void istanciaBaseDeDados(){


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		todo t1 = new todo(null,"Estudar", "Estudar Spring Boot 2", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
        todo t2 = new todo(null,"Compras", "Compras do Mês", LocalDateTime.parse("25/03/2022 10:58", formatter), false);
        todo t3 = new todo(null,"Vasco", "Da Gama", LocalDateTime.parse("25/03/2022 10:45", formatter), true);
        todo t4 = new todo(null,"Fazer Notion", "Fazer anotações no Notion", LocalDateTime.parse("28/03/2022 08:40", formatter), true);
		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
    }


}