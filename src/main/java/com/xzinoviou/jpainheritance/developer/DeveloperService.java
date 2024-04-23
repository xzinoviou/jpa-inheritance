package com.xzinoviou.jpainheritance.developer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public List<Developer> getAll() {
        return developerRepository.findAll();
    }

    public Developer getById(Long id) {
        return developerRepository.findById(id).orElseThrow(() -> new RuntimeException("Developer not found: " + id));
    }

    public Developer create(Developer developer) {
        return developerRepository.save(developer);
    }

    public void delete(Long id) {
        developerRepository.deleteById(id);
    }

}
