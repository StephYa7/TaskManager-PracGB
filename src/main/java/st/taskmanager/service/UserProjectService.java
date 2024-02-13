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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UsersProjectRepository usersProjectRepository;
    private UserRepository userRepository;
    private ProjectRepository projectRepository;


    public List<User> getUsersByProjectId(Long projectId) {
        return usersProjectRepository.findAll()
                .stream()
                .filter(u -> u.getId().getProjectId().equals(projectId))
                .map(u -> u.getUser()).collect(Collectors.toList());
    }

    public List<Project> getProjectsByUserId(Long userId) {
        return usersProjectRepository.findAll()
                .stream()
                .filter(u -> u.getId().getUserId().equals(userId))
                .map(u -> u.getProject()).collect(Collectors.toList());
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
        usersProjectRepository.delete(usersProjectRepository.findAll()
                .stream()
                .filter(project -> project.getId().getProjectId() == projectId)
                .filter(user -> user.getId().getUserId() == userId).findFirst().get());


    }
}