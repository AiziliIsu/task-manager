package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskService {

    private final Map<String, Task> taskMap = new ConcurrentHashMap<>();

    // Add a task
    public void addTask(Task task) {
        if (task == null || task.getId() == null || task.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Task or Task ID cannot be null or empty.");
        }
        taskMap.put(task.getId(), task);
    }

    // Get a task by ID
    public Task getTask(String id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found.");
        }
        return taskMap.get(id);
    }

    // Update a task
    public Task updateTask(String id, Task updatedTask) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found.");
        }

        Task existingTask = taskMap.get(id);
        existingTask.setName(updatedTask.getName());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());

        taskMap.put(id, existingTask); // Save the updated task back to the map
        return existingTask;
    }

    // Delete a task
    public void deleteTask(String id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found.");
        }
        taskMap.remove(id);
    }

    // Get all tasks
    public Map<String, Task> getAllTasks() {
        return taskMap;
    }
}
