package frist.app.newapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frist.app.newapp.entities.task.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    TaskEntity save(TaskEntity task);

    List<TaskEntity> findAll();

    Optional<TaskEntity> findById(Long id);
}