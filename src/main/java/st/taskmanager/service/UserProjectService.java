package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.taskmanager.model.Project;
import st.taskmanager.model.User;
import st.taskmanager.model.UserProjectKey;
import st.taskmanager.model.UsersProject;
import st.taskmanager.repository.ProjectRepository;
import st.taskmanager.repository.UserRepository;
import st.taskmanager.repository.UsersProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UsersProjectRepository usersProjectRepository;
    private UserRepository userRepository;
    private ProjectRepository projectRepository;


    public List<User> getUsersByProjectId(Long projectId) {
        List<UsersProject> allByProjectId = usersProjectRepository.findAllByProjectId(projectId);
        return allByProjectId.stream().map(UsersProject::getUser).toList();
    }

    public List<Project> getProjectsByUserId(Long userId) {
        List<UsersProject> allByUserId = usersProjectRepository.findAllByUserId(userId);
        return allByUserId.stream().map(UsersProject::getProject).toList();
    }

    public void addUserToProject(Long userId, Long projectId) {
        UsersProject userProject = new UsersProject();
        UserProjectKey userProjectKey = new UserProjectKey();
        userProjectKey.setUserId(userId);
        userProjectKey.setProjectId(projectId);

        userProject.setId(userProjectKey);
        userProject.setUser(userRepository.findById(userId).get());
        userProject.setProject(projectRepository.findById(projectId).get());

        usersProjectRepository.save(userProject);
    }

    public void removeUserFromProject(Long userId, Long projectId) {
        UsersProject delete = usersProjectRepository.findByProjectIdAndUserId(userId, projectId);
        usersProjectRepository.delete(delete);
    }
}