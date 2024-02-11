package st.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import st.taskmanager.model.User;
import st.taskmanager.service.UserProjectService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController("/projects")
public class UserProjectController {

    private UserProjectService userProjectService;


    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long id) {
        List<User> users = userProjectService.getUsersByProjectId(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List> getProjectsByUserId(Long userId) {
        return (ResponseEntity<List>) userProjectService.getProjectsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity addUserToProject(Long userId, Long projectId) {
        userProjectService.addUserToProject(userId, projectId);

        return
    }

    @PostMapping
    public ResponseEntity<User> removeUserFromProject(Long userId, Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);

        return
    }
}