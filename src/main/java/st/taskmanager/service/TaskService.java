package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.taskmanager.controller.TaskRepository;
import st.taskmanager.model.Task;
import st.taskmanager.model.TaskStatus;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;


    public Task addTask(Task task) {
        return taskRepository.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {
        return taskRepository.updateTaskStatus(id, task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
}