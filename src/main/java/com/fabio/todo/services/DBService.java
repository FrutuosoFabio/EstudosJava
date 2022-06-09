package com.fabio.todo.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.todo.Repositories.TodoRepository;
import com.fabio.todo.domain.todo;


@Service
public class DBService {


    @Autowired
	private TodoRepository todoRepository;
  

    
    public void istanciaBaseDeDados() throws ParseException{


        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		todo t1 = new todo(null,"Estudar", "Estudar Spring Boot 2", sdf.parse("25/03/2022"), false);
        todo t2 = new todo(null,"Compras", "Compras do Mês", sdf.parse("25/03/2022"), true);
        todo t3 = new todo(null,"Vasco", "Da Gama", sdf.parse("25/03/2022"), true);
        todo t4 = new todo(null,"Fazer Notion", "Fazer anotações no Notion", sdf.parse("28/03/2022"), true);
		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
    }


}