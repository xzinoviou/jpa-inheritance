package com.xzinoviou.jpainheritance.developer;

import com.xzinoviou.jpainheritance.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@Table(name = "DEVELOPER", schema = "jpa_test_db_schema")
@Setter
@Getter
public class Developer extends Employee {

    @Column(name = "SENIORITY")
    private String seniority;
}
