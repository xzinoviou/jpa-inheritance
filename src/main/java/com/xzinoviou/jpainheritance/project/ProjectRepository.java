package com.xzinoviou.jpainheritance.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
