package st.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import st.taskmanager.model.Project;
import st.taskmanager.model.User;
import st.taskmanager.service.UserProjectService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/projects")
public class UserProjectController {

    private UserProjectService userProjectService;


    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable("id") Long id) {
        List<User> users = userProjectService.getUsersByProjectId(id);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable("id") Long userId) {
        List<Project> projects = userProjectService.getProjectsByUserId(userId);
        if (projects.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projects);
    }

    @PostMapping()
    public ResponseEntity<Void> addUserToProject(Long userId, Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/delete")
    public ResponseEntity<Void> removeUserFromProject(Long userId, Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }
}