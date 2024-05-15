package frist.app.newapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frist.app.newapp.entities.task.TaskEntity;
import frist.app.newapp.entities.task.dto.TaskEntityDto;
import frist.app.newapp.entities.task.dto.TaskEntityPostUpdateDto;
import frist.app.newapp.excption.MyCustomException;
import frist.app.newapp.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public TaskEntityDto createTask(TaskEntityPostUpdateDto taskDto) {
        TaskEntity task = new TaskEntity();
        if (taskDto.getTaskStartDate().isAfter(taskDto.getTaskEndDate())) {
            throw new MyCustomException("Task End Date should be after Task Start Date");
        }
        task.setTitle(taskDto.getTaskName());
        task.setDescription(taskDto.getTaskDescription());
        task.setStartDate(taskDto.getTaskStartDate());
        task.setEndDate(taskDto.getTaskEndDate());
        repository.save(task);
        TaskEntityDto taskEntityDto = new TaskEntityDto(task);
        return taskEntityDto;
    }

    public List<TaskEntityDto> retrieveAllTasks() {
        return repository.findAll().stream().map(x -> new TaskEntityDto(x)).collect(Collectors.toList());
    }

    public TaskEntityDto retrieveOneTask(Long id) {
        TaskEntity task = repository.findById(id).orElse(null);
        TaskEntityDto taskEntityDto = new TaskEntityDto(task);
        return taskEntityDto;
    }

}
