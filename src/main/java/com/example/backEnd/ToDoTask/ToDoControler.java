package com.example.backEnd.ToDoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ToDoControler {

    private final ToDoService toDoService;
    @Autowired
    public ToDoControler(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @GetMapping
    public List<ToDo> getAllTasks(){
        return toDoService.getAllTasks();
    }
    @GetMapping(path="index")
    public String vratiSite() throws IOException {
        return index();
    }
    @PostMapping(path="/createTask")
    public void addTask(@RequestBody ToDo todo){
        System.out.println("Done, task added");
        toDoService.addTask(todo);

    }
    @PostMapping(path="/completeTask")
    public void isCompleted(String taskName, boolean isCompleted){
        System.out.println("Done, task completed");
        toDoService.isCompleted(taskName, isCompleted);

    }
    public String index() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/backEnd/ToDoTask/ToDoHtml.html"));
        String all;
        try{
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while(line!=null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line= reader.readLine();
            }
            all=sb.toString();
        } finally {
            reader.close();
        }
        return all;
    }
}
