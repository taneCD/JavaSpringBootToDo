package com.example.backEnd.ToDoTask;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ToDo {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="iscompleted")
    private boolean isCOmpleted;
    @Column(name="taskname")
    private String taskName;

    public ToDo() {
    }

    public ToDo(boolean isCOmpleted, String taskName) {
        this.isCOmpleted = isCOmpleted;
        this.taskName = taskName;
    }

    public boolean isCOmpleted() {
        return isCOmpleted;
    }

    public void setCOmpleted(boolean COmpleted) {
        isCOmpleted = COmpleted;
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
                "isCOmpleted=" + isCOmpleted +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
