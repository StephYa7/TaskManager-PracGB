package st.taskmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.taskmanager.model.Project;
import st.taskmanager.model.User;
import st.taskmanager.model.UsersProject;
import st.taskmanager.repository.UsersProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UsersProjectRepository usersProjectRepository;


    public List<User> getUsersByProjectId(Long projectId) {
        return usersProjectRepository.findAll()
                .stream()
                .filter(u -> u.getProjectId().equals(projectId))
                .map(u -> u.getUser()).collect(Collectors.toList());
    }

    public List<Project> getProjectsByUserId(Long userId) {
        return usersProjectRepository.findAll()
                .stream()
                .filter(u -> u.getUser().equals(userId))
                .map(u -> u.getProject()).collect(Collectors.toList());
    }

    public void addUserToProject(Long userId, Long projectId) {
        UsersProject userProject = new UsersProject();
        userProject.setUserId(userId);
        userProject.setProjectId(projectId);
        usersProjectRepository.save(userProject);
    }

    public void removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.delete(usersProjectRepository.findAll()
                .stream()
                .filter(project -> project.getId() == projectId)
                .filter(user -> user.getId() == userId).findFirst().get());


    }
}