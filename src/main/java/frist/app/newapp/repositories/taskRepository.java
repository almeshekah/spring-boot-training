package frist.app.newapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import frist.app.newapp.entities.task.taskEntity;

public interface taskRepository extends JpaRepository<taskEntity, Long> {

    taskEntity save(taskEntity task);

    List<taskEntity> findAll();

    Optional<taskEntity> findById(Long id);
}