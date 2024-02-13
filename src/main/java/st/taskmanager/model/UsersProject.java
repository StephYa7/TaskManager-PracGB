package st.taskmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_projects")
public class UsersProject {


    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "user_id")
    private Long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}