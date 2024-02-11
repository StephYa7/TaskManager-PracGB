package st.taskmanager.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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