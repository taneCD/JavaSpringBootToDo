package com.example.backEnd.ToDoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoControler {

    @Autowired
    ToDoRepository repository;

//    @GetMapping
//    public List<ToDo> getAllTasks(){
//        return repository.findAll();
//    }
    @PostMapping("/addTask")
    public void addTask(@RequestBody ToDo todo){
        repository.save(todo);
    }
}
