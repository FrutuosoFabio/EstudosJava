package com.fabio.todo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fabio.todo.domain.todo;
@Repository
public interface TodoRepository extends JpaRepository<todo,Integer> {
    @Query("SELECT obj FROM todo obj WHERE obj.finalizar = false ORDER BY obj.dataParaFinalizar")
    List<todo> findAllOpen();

    @Query("SELECT obj FROM todo obj WHERE obj.finalizar = true ORDER BY obj.dataParaFinalizar")
    List<todo> findAllClosed();  
       


}
