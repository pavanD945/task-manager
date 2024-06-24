package org.rvce.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.rvce.taskmanager.enums.TaskStatus;

import java.util.Date;

@Data
@Entity
@Table(name = "task")
public class Task {  // Always give singular

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_on")
    private Date lastModifiedOn;
}
