package com.example.demo.controller;

import com.example.demo.model.Disease;
import com.example.demo.repository.entity.DiseaseEntity;
import com.example.demo.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/diseases")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Disease disease) {
        diseaseService.saveDisease(disease);
    }

    @GetMapping(value = "/{id}/category/{category}")
    public ResponseEntity<Optional<DiseaseEntity>> get(@PathVariable String id, @PathVariable String category) {
        return ResponseEntity.ok(diseaseService.findById(id, category));
    }

    @DeleteMapping(value = "/{id}/category/{category}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id, @PathVariable String category) {
        diseaseService.delete(id, category);
    }

    @GetMapping
    public ResponseEntity<List<DiseaseEntity>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(diseaseService.findDiseaseByName(name));
    }
}
