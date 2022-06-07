package com.fabio.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.todo.domain.todo;
import com.fabio.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<todo> findById(@PathVariable Integer id) {

        todo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<todo>> listOpen() {

        List<todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/closed")
    public ResponseEntity<List<todo>> listClosed() {

        List<todo> list = service.findAllClosed();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<todo>> listAll() {

        List<todo> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @PostMapping
    public ResponseEntity<todo> create(@RequestBody todo obj) {
        obj = service.create(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();


    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<todo> update(@PathVariable Integer id, @RequestBody todo obj) {
        todo newObj = service.update(id,obj);
        return ResponseEntity.ok().body(newObj);
      


    }

}
