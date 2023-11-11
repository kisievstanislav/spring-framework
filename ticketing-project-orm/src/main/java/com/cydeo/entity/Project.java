package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity{

    private String projectName;
    private String projectCode;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;



    @Enumerated(EnumType.STRING)
    private Status projectStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User assignedManager;


}
