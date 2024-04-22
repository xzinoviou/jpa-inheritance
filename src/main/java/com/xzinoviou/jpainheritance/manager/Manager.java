package com.xzinoviou.jpainheritance.manager;

import com.xzinoviou.jpainheritance.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Table(name = "MANAGER", schema = "jpa_test_db_schema")
@PrimaryKeyJoinColumn(name = "managerId")
@Setter
@Getter
public class Manager extends Employee {

    @Column(name = "DIVISION")
    private String division;
}
