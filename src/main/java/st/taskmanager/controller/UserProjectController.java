package st.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import st.taskmanager.service.UserProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserProjectController {

    private UserProjectService userProjectService;


    @GetMapping
    public ResponseEntity<List> getUsersByProjectId(Long projectId) {
        return (ResponseEntity<List>) userProjectService.getUsersByProjectId(projectId);
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
    public ResponseEntity removeUserFromProject(Long userId, Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);

        return new ResponseEntity<>(projectId, );
    }
}