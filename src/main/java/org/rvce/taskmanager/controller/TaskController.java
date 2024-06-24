package org.rvce.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.rvce.taskmanager.dto.TaskDTO;
import org.rvce.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> find(@PathVariable("id") Long id) {
        TaskDTO taskDTO = taskService.find(id);
        if (taskDTO != null) {
            return new ResponseEntity<>(taskService.find(id), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.FOUND);
    }

    //Bulk update is out of scope
    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> findAllTasks(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.update(id, taskDTO), HttpStatus.FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<TaskDTO> findByName(@RequestParam("name") String name) {
        TaskDTO taskDTO = taskService.findByName(name);
        if (taskDTO != null) {
            return new ResponseEntity<>(taskService.findByName(name), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
