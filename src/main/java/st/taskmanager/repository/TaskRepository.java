package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import st.taskmanager.model.Task;
import st.taskmanager.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    @Query(value = "SELECT * FROM tasks WHERE status = :status", nativeQuery = true)
    List<Task> findAllTasksByStatus(@Param("status") String status);


    @Modifying
    @Query("UPDATE Task t SET t.status = :newStatus WHERE t.id = :taskId")
    void updateTaskStatusByID(@Param("taskId") Long taskId, @Param("newStatus") TaskStatus newStatus);


}