package org.rvce.taskmanager.repository;

import org.rvce.taskmanager.entity.Task;
import org.rvce.taskmanager.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByName(String name);

    List<Task> findByStatus(TaskStatus status);
}
