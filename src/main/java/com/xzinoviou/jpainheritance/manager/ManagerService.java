package com.xzinoviou.jpainheritance.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    public Manager getById(Long id) {
        return managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found: " + id));
    }

    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

}
