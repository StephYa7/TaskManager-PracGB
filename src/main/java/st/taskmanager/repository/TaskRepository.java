package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.taskmanager.model.Task;
import st.taskmanager.util.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(TaskStatus status);
}