package com.xzinoviou.jpainheritance.project;

import com.xzinoviou.jpainheritance.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Table(name = "PROJECT", schema = "jpa_test_db_schema")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", length = 100)
    private String title;

    @OneToMany(fetch = LAZY, cascade = {MERGE, PERSIST}, orphanRemoval = true, mappedBy = "project")
    private Set<ProjectMember> projectMembers = new LinkedHashSet<>();


    public void addMember(Employee employee) {
        ProjectMember projectMember = new ProjectMember(employee, this);
        projectMembers.add(projectMember);
        employee.getProjectMembers().add(projectMember);
    }

    public void deleteMember(Employee employee) {
        for (Iterator<ProjectMember> iterator = projectMembers.iterator(); iterator.hasNext(); ) {
            ProjectMember projectMember = projectMembers.iterator().next();

            if (projectMember.getProject().equals(this) && projectMember.getEmployee().equals(employee)) {
                iterator.remove();
                projectMember.getEmployee().getProjectMembers().remove(projectMember);
                projectMember.setProject(null);
                projectMember.setEmployee(null);
            }
        }
    }
}
