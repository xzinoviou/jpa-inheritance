package com.xzinoviou.jpainheritance.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
