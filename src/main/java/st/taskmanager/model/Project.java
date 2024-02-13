package st.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import st.taskmanager.util.MyLocalDateTimeDeserializer;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true, name = "date_created")
    @JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "project")
    @Transient
    private List<UsersProject> userProjects;

    @Override

    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}