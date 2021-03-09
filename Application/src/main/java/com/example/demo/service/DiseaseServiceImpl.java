package com.example.demo.service;

import com.azure.data.cosmos.PartitionKey;
import com.example.demo.mapper.DiseaseMapper;
import com.example.demo.model.Disease;
import com.example.demo.repository.DiseaseRepository;
import com.example.demo.repository.entity.DiseaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository repository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public void delete(String id, String category) {
        repository.deleteById(id, new PartitionKey(category));
    }

    @Override
    public List<DiseaseEntity> findDiseaseByName(String name) {
        return repository.findByDiseaseName(name);
    }

    @Override
    public Optional<DiseaseEntity> findById(String id, String category) {
        return repository.findById(id, new PartitionKey(category));
    }

    @Override
    public void saveDisease(Disease disease) {
        var diseaseEntity = diseaseMapper.mapToDiseaseEntity(disease);
        repository.save(diseaseEntity);
    }
}
