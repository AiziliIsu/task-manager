package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Add a new task
    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        if (task == null || task.getId() == null || task.getName() == null) {
            return new ResponseEntity<>("Invalid task data", HttpStatus.BAD_REQUEST);
        }
        taskService.addTask(task);
        return new ResponseEntity<>("Task added successfully.", HttpStatus.CREATED);
    }

    // Get a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable String id) {
        try {
            Task task = taskService.getTask(id); // Exception already thrown if not found
            return ResponseEntity.ok(task);
        } catch (TaskNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update a task by ID
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // DELETE Method

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        try {
            taskService.deleteTask(id); // Exception thrown if not found
            return ResponseEntity.noContent().build();
        } catch (TaskNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<Map<String, Task>> getAllTasks() {
        // Clean the map to remove null keys
        Map<String, Task> tasks = taskService.getAllTasks().entrySet().stream()
                .filter(entry -> entry.getKey() != null) // Exclude null keys
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
