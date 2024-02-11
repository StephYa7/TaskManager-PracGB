package st.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import st.taskmanager.model.Task;
import st.taskmanager.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public void updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTaskStatus(id, task.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}