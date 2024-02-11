package st.taskmanager.service;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserProjectService {
    public List getUsersByProjectId(Long projectId) {
        return new ArrayList();
    }

    public List getProjectsByUserId(Long userId) {
        return new ArrayList();
    }

    public void addUserToProject(Long userId, Long projectId) {
    }

    public void removeUserFromProject(Long userId, Long projectId) {
    }
}