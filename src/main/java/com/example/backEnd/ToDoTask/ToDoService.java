package com.example.backEnd.ToDoTask;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    public void addTask(ToDo todo){
        Optional<ToDo>toDoOptional = toDoRepository.findTaskByName(todo.getTaskName());
        toDoRepository.save(todo);
    }
    public List<ToDo> getAllTasks(){
        return toDoRepository.findAll();
    }
    @Transactional
    public void isCompleted(String taskName, boolean isCompleted){
        ToDo todo = toDoRepository.findTaskByName(taskName).orElseThrow(()->new IllegalStateException("student with id "+taskName+" does not exist"));
        todo.setCOmpleted(isCompleted);
    }
}
