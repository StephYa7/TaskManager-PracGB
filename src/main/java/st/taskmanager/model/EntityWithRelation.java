package st.taskmanager.model;

import jakarta.persistence.*;

@Entity
public abstract class EntityWithRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long relatedEntityId;
}