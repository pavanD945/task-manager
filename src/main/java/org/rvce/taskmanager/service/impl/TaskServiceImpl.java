package org.rvce.taskmanager.service.impl;

import lombok.AllArgsConstructor;
import org.rvce.taskmanager.dto.TaskDTO;
import org.rvce.taskmanager.entity.Task;
import org.rvce.taskmanager.enums.TaskStatus;
import org.rvce.taskmanager.exception.ResourceNotFoundException;
import org.rvce.taskmanager.mapper.TaskMapper;
import org.rvce.taskmanager.repository.TaskRepository;
import org.rvce.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        Task task = TaskMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.toDTO(savedTask);
    }

    public TaskDTO find(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        System.out.println("I am inside the service impl class");
        TaskDTO taskDTO;
        if (task.isPresent()) {
            taskDTO = TaskMapper.toDTO(task.get());
        } else {
            throw new ResourceNotFoundException("Task id not found: " + id);
        }

        return taskDTO;
    }

    @Override
    public List<TaskDTO> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return TaskMapper.toDTOList(tasks);
    }

    @Override
    public TaskDTO update(Long id, TaskDTO taskDTO) {
        Optional<Task> taskDTOFromDB = taskRepository.findById(id);
        TaskDTO taskDTOUpdated;
        if (!taskDTOFromDB.isPresent()) {
            throw new ResourceNotFoundException("Task id does not exist. ID = " + id);
        } else {
            Task task = taskDTOFromDB.get();
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            taskDTOUpdated = TaskMapper.toDTO(taskRepository.save(task));
        }
        return taskDTOUpdated;
    }

    @Override
    public TaskDTO findByName(String name) {
        Task task = taskRepository.findByName(name);
        if (task == null) {
            return null;
        }
        return TaskMapper.toDTO(task);
    }
}
