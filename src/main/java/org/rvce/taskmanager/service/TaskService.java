package org.rvce.taskmanager.service;

import org.rvce.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO find(Long id);

    List<TaskDTO> findAllTasks();

    TaskDTO update(Long id, TaskDTO taskDTO);

    TaskDTO findByName(String name);

    List<TaskDTO> findByStatus(String status);
}
