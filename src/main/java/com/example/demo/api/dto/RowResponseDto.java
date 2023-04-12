package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RowResponseDto {
    private String PM10;
    private String PM25;

//    @Override
//    public String toString() {
//        return "RowResponseDto{" +
//                "PM10=" + PM10 +
//                "PM25=" + PM25 +
//                '}';
//    }
}
