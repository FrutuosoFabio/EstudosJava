package com.fabio.todo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.todo.Repositories.TodoRepository;
import com.fabio.todo.domain.todo;;


@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public todo findById(Integer id){
 
        Optional<todo> obj=repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto Não Encontrado! id:" + id + ", Tipo:" + todo.class.getName(), null ));
    }

    public List<todo> findAllOpen() {
        List<todo> list = repository.findAllOpen();
        return list;        
    }
    
    public List<todo> findAllClosed() {
        List<todo> list = repository.findAllClosed();
        return list;        
    }

    public List<todo> findAll() {
        List<todo> list = repository.findAll();
        return list; 
    }

    public todo create(todo obj) {
         obj.setId(null);  
         return repository.save(obj);
    }

    public void delete(Integer id) {
      repository.deleteById(id);
    }

    

    }
    

