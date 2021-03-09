package com.example.demo.service;

import com.example.demo.model.Disease;
import com.example.demo.repository.entity.DiseaseEntity;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {
    void delete(String id, String category);

    List<DiseaseEntity> findDiseaseByName(String name);

    Optional<DiseaseEntity> findById(String id, String category);

    void saveDisease(Disease disease);
}
