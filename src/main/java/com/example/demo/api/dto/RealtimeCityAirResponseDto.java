package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RealtimeCityAirResponseDto {
    private List<RowResponseDto> row;

//    @Override
//    public String toString() {
//        return "RealtimeCityAirResponseDto{" +
//                "RowResponseDto=" + row +
//                '}';
//    }
}
