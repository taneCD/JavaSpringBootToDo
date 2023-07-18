package com.example.backEnd.ToDoTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Query("SELECT s FROM todo s WHERE s.taskName = ?1")
    Optional<ToDo>findTaskByName(String name);
}
