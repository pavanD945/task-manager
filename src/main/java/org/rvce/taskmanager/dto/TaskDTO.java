package org.rvce.taskmanager.dto;

import lombok.Data;
import org.rvce.taskmanager.enums.TaskStatus;

import java.util.Date;

@Data
public class TaskDTO {

    private Long id;
    private String name;
    private TaskStatus status;
    private String description;
    private Date createdOn;
    private String createdBy;
    private Date lastModifiedOn;
}
