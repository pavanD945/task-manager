package org.rvce.taskmanager.repository;

import org.rvce.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByName(String name);
}
