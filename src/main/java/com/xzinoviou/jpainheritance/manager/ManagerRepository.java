package com.xzinoviou.jpainheritance.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
