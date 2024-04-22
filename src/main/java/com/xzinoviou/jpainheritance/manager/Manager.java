package com.xzinoviou.jpainheritance.manager;

import com.xzinoviou.jpainheritance.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Xenofon Zinoviou
 */
@Entity
@DiscriminatorValue(value = "MANAGER")
@Setter
@Getter
public class Manager extends Employee {

    @Column(name = "DIVISION")
    private String division;
}
