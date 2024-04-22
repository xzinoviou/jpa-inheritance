package com.xzinoviou.jpainheritance.employee;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY")
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
}
