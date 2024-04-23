package com.xzinoviou.jpainheritance.developer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<Developer>> getAll() {
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Developer> create(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerService.create(developer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        developerService.delete(id);
    }

}
