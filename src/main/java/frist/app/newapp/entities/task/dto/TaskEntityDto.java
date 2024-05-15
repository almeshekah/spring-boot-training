package frist.app.newapp.entities.task.dto;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import frist.app.newapp.entities.task.TaskEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskEntityDto {

    private String taskName;

    private String taskDescription;

    private LocalDate taskStartDate;

    private LocalDate taskEndDate;

    public TaskEntityDto(TaskEntity task) {
        this.taskName = task.getTitle();
        this.taskDescription = task.getDescription();
        this.taskStartDate = task.getStartDate();
        this.taskEndDate = task.getEndDate();
    }

    public TaskEntityDto(HttpStatus badRequest, String message) {
        //TODO Auto-generated constructor stub
    }

}
