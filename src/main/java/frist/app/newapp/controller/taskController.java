package frist.app.newapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import frist.app.newapp.repositories.taskRepository;
import frist.app.newapp.entities.task.taskEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class taskController {
    private final taskRepository repository;

    @PostMapping
    public taskEntity addTask(@RequestBody taskEntity task) {
        return repository.save(task);
    }

    @GetMapping
    public List<taskEntity> getAllTasks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public taskEntity getTaskById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}