package st.taskmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Enum<TaskStatus> status;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, name = "date_created")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime dateCreated;

    public Task(Enum<TaskStatus> status, String description) {
        this.status = status;
        this.description = description;
    }
}