package com.example.backEnd.ToDoTask;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ToDo {
    @Id
    private Long id;
    private String taskName;

    public ToDo() {
    }

    public ToDo(Long id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
