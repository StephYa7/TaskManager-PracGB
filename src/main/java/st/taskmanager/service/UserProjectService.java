package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.taskmanager.model.User;
import st.taskmanager.repository.ProjectRepository;
import st.taskmanager.repository.UserRepository;
import st.taskmanager.repository.UsersProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UsersProjectRepository usersProjectRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;



    public List<User> getUsersByProjectId(Long projectId) {
        return new ArrayList<>();
    }

    public List getProjectsByUserId(Long userId) {
        return new ArrayList();
    }

    public void addUserToProject(Long userId, Long projectId) {
    }

    public void removeUserFromProject(Long userId, Long projectId) {
    }
}