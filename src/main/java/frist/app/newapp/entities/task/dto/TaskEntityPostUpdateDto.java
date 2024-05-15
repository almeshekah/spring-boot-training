package frist.app.newapp.entities.task.dto;

import java.time.LocalDate;

import org.springframework.lang.NonNull;
import frist.app.newapp.entities.task.TaskEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * TaskEntityPostUpdateDto
 */
@Setter
@Getter
public class TaskEntityPostUpdateDto {

    @NonNull
    private String taskName;

    private String taskDescription;

    private LocalDate taskStartDate;

    private LocalDate taskEndDate;

    public TaskEntityPostUpdateDto(String taskName, String taskDescription, LocalDate taskStartDate,
            LocalDate taskEndDate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
    }

}