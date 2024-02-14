package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.taskmanager.model.UsersProject;

import java.util.List;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    UsersProject findByProjectIdAndUserId(Long userId, Long projectId);

    List<UsersProject> findAllByProjectId(Long projectId);

    List<UsersProject> findAllByUserId(Long userId);

}