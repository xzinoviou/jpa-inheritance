package com.xzinoviou.jpainheritance.employee;

import com.xzinoviou.jpainheritance.project.ProjectMember;
import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Table(name = "EMPLOYEE", schema = "jpa_test_db_schema")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MANAGER")
    private boolean manager;

    @Column(name = "TITLE", length = 50)
    private String title;

    @OneToMany(fetch = LAZY, cascade = {MERGE, PERSIST}, orphanRemoval = true, mappedBy = "employee")
    private Set<ProjectMember> projectMembers = new LinkedHashSet<>();
}
