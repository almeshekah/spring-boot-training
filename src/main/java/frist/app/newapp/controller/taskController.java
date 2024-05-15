package frist.app.newapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frist.app.newapp.entities.task.dto.TaskEntityDto;
import frist.app.newapp.entities.task.dto.TaskEntityPostUpdateDto;
import frist.app.newapp.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public TaskEntityDto addTask(@RequestBody TaskEntityPostUpdateDto taskDto) {
        return service.createTask(taskDto);
    }

    @GetMapping
    public List<TaskEntityDto> getAllTasks() {
        return service.retrieveAllTasks();
    }

    @GetMapping("/{id}")
    public TaskEntityDto getTaskById(@PathVariable Long id) {
        return service.retrieveOneTask(id);
    }
}