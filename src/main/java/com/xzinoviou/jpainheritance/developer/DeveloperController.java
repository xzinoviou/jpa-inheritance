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

    private final DeveloperRepository developerRepository;

    @GetMapping
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        return ResponseEntity.ok(developerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id) {
        return ResponseEntity.ok(developerRepository.findById(id).orElseThrow(() -> new RuntimeException("Developer not found: " + id)));
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerRepository.save(developer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloperById(@PathVariable Long id) {
        developerRepository.deleteById(id);
    }

}
