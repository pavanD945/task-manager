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
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TaskDTO> find(@PathVariable("id") Long id) {
        TaskDTO taskDTO = taskService.find(id);
        if (taskDTO != null) {
            return new ResponseEntity<>(taskService.find(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    //Bulk update is out of scope
    @PutMapping("{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TaskDTO> findAllTasks(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.update(id, taskDTO), HttpStatus.OK);
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TaskDTO> findByName(@RequestParam("name") String name) {
        TaskDTO taskDTO = taskService.findByName(name);
        if (taskDTO != null) {
            return new ResponseEntity<>(taskDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filtered")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<TaskDTO>> findByStatus(@RequestParam("status") String status) {
        List<TaskDTO> taskDTO = taskService.findByStatus(status);
        if (taskDTO != null) {
            return new ResponseEntity<>(taskDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
