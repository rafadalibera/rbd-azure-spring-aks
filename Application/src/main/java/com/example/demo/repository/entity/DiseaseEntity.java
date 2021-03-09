package com.example.demo.repository.entity;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@Document(collection = "diseases")
public class DiseaseEntity {

    @Id
    private String diseaseId;

    private String diseaseName;

    private double mifts;

    @PartitionKey
    private String diseaseCategory;
}
