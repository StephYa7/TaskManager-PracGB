package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import st.taskmanager.model.Task;
import st.taskmanager.util.TaskStatus;
import st.taskmanager.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;


    public Task addTask(Task task) {
        return taskRepository.save(task);
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Optional<Task> updateTaskStatus(Long id, Task task) {
        Optional<Task> updateTask = taskRepository.findById(id);
        updateTask.ifPresent(o -> o.setStatus(task.getStatus()));
        return updateTask;
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
    }


}