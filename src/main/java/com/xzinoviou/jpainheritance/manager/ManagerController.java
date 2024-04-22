package com.xzinoviou.jpainheritance.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerRepository managerRepository;

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers() {
        return ResponseEntity.ok(managerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found: " + id)));
    }

    @PostMapping
    public ResponseEntity<Manager> createDeveloper(@RequestBody Manager manager) {
        return new ResponseEntity<>(managerRepository.save(manager), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteManagerById(@PathVariable Long id) {
        managerRepository.deleteById(id);
    }
}
