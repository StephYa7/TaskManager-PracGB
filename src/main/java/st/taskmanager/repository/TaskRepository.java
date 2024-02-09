package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import st.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}