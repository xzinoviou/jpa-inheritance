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

    private final ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<Manager>> getAll() {
        return ResponseEntity.ok(managerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getById(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Manager> create(@RequestBody Manager manager) {
        return new ResponseEntity<>(managerService.create(manager), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        managerService.delete(id);
    }
}
