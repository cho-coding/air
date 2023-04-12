package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDto {
    private RealtimeCityAirResponseDto RealtimeCityAir;

    public ApiResponseDto() {}

    @JsonCreator
    public ApiResponseDto(@JsonProperty("RealtimeCityAir") RealtimeCityAirResponseDto realtimeCityAir) {
        RealtimeCityAir = realtimeCityAir;
    }

    @Override
    public String toString() {
        return "ApiResponseDto{" +
                "RealtimeCityAir=" + RealtimeCityAir +
                '}';
    }
}


