package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.taskmanager.model.UsersProject;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
}