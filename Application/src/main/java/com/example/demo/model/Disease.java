package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

    @JsonProperty("disease_id")
    private String diseaseId;

    @JsonProperty("disease_name")
    private String diseaseName;

    @JsonProperty("mifts")
    private double mifts;

    @JsonProperty("disease_category")
    private String diseaseCategory;
}
