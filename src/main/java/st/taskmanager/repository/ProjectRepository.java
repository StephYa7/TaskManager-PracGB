package st.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.taskmanager.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}