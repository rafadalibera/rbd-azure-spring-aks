package com.example.demo.repository;

import com.example.demo.repository.entity.DiseaseEntity;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import java.util.List;

public interface DiseaseRepository extends CosmosRepository<DiseaseEntity, String> {

    List<DiseaseEntity> findByDiseaseName(String Name);
}
