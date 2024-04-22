package com.xzinoviou.jpainheritance.developer;

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
@DiscriminatorValue(value = "DEVELOPER")
@Setter
@Getter
public class Developer extends Employee {

    @Column(name = "SENIORITY")
    private String seniority;
}
