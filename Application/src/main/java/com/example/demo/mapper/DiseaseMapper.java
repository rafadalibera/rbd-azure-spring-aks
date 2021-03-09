package com.example.demo.mapper;

import com.example.demo.model.Disease;
import com.example.demo.repository.entity.DiseaseEntity;
import org.springframework.stereotype.Component;

@Component
public class DiseaseMapper {

    public DiseaseEntity mapToDiseaseEntity (Disease disease) {
        return DiseaseEntity.builder()
                .diseaseId(disease.getDiseaseId())
                .diseaseCategory(disease.getDiseaseCategory())
                .diseaseName(disease.getDiseaseName())
                .mifts(disease.getMifts())
                .build();
    }
}
