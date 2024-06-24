package org.rvce.taskmanager.mapper;

import org.rvce.taskmanager.dto.TaskDTO;
import org.rvce.taskmanager.entity.Task;
import org.rvce.taskmanager.enums.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    // TODO: I can use an auto code-generator

    public static TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setDescription(task.getDescription());

        taskDTO.setLastModifiedOn(task.getLastModifiedOn());
        taskDTO.setCreatedBy(task.getCreatedBy());
        taskDTO.setCreatedOn(task.getCreatedOn());

        return taskDTO;
    }

    public static Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();

        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setStatus(taskDTO.getStatus());
        task.setDescription(taskDTO.getDescription());
        task.setLastModifiedOn(taskDTO.getLastModifiedOn());
        task.setCreatedBy(taskDTO.getCreatedBy());
        task.setCreatedOn(taskDTO.getCreatedOn());

        return task;
    }

    public static List<TaskDTO> toDTOList(List<Task> tasks) {
        // TODO: I can use stream function
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task: tasks) {
            taskDTOList.add(toDTO(task));
        }
        return taskDTOList;
    }
}
