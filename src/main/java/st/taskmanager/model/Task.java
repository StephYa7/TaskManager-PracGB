package st.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import st.taskmanager.util.MyLocalDateTimeDeserializer;

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

    @Column(nullable = false)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true, name = "date_created")
    @JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
    private LocalDateTime dateCreated;
}