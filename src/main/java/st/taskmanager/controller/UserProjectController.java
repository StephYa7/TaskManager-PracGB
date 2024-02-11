package st.taskmanager.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserProjectController {



    public ResponseEntity<List> getUsersByProjectId(Long projectId){
        return new ResponseEntity<>();
    }
    public ResponseEntity<List> getProjectsByUserId(Long userId){

    }
    public ResponseEntity addUserToProject(Long userId, Long projectId){

    }
    public ResponseEntity removeUserFromProject(Long userId, Long projectId){

    }
}