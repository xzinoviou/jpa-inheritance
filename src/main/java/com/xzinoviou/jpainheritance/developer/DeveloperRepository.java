package com.xzinoviou.jpainheritance.developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
