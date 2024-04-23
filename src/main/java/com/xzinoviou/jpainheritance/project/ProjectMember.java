package com.xzinoviou.jpainheritance.project;

import com.xzinoviou.jpainheritance.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Table(name = "PROJECT_MEMBER", schema = "jpa_test_db_schema")
@Data
@NoArgsConstructor
public class ProjectMember {

    @EmbeddedId
    private ProjectMemberId id;

    @ManyToOne(fetch = LAZY, cascade = {MERGE, PERSIST})
    @MapsId("employeeId")
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = LAZY, cascade = {MERGE, PERSIST})
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "OWNER")
    private boolean owner;

    public ProjectMember(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
        this.id = new ProjectMemberId(employee.getId(), project.getId());
    }
}
