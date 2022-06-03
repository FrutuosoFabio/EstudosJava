package com.fabio.todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.todo.domain.todo;
@Repository
public interface TodoRepository extends JpaRepository<todo,Integer> {
    
}
