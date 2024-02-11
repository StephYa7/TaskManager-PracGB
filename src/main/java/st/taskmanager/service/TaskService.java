package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import st.taskmanager.model.Task;
import st.taskmanager.util.TaskStatus;
import st.taskmanager.repository.TaskRepository;

import java.util.List;

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

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findAllTasksByStatus(status);
    }

    @Transactional
    public void updateTaskStatus(Long id, TaskStatus status) {
         taskRepository.updateTaskStatusByID(id, status);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
    }


}