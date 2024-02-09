package st.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import st.taskmanager.model.Task;
import st.taskmanager.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRepository {

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return new Task();
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return new ArrayList<Task>();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {


        return new ArrayList<Task>();
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return new Task();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {

    }

}