package st.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import st.taskmanager.util.TaskStatus;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(nullable = false,name = "description")
    private String description;

    @Column(nullable = true, name = "date_created")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateCreated;
}