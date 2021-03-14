package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleMessage implements Serializable {

    @JsonProperty("message")
    private String message;

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;

}
