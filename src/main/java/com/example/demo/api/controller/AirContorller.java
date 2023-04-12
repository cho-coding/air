package com.example.demo.api.controller;

import com.example.demo.api.dto.ApiResponseDto;
import com.example.demo.api.service.AirService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AirContorller {

    private final AirService airService;

    @GetMapping("/api")
    @ResponseBody
    public ApiResponseDto getAirBad() throws IOException {

        String jsonString = airService.getAirBad();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //자바 객체 -> json 변환
        String objectNode = objectMapper.writeValueAsString(jsonString);
        System.out.println(objectNode);

        JsonNode jsonNode = objectMapper.readTree(jsonString);
        System.out.println(jsonNode);

        //json -> 자바 객체로 변환
//        ObjectNode ond = objectMapper.createObjectNode();
//        ond.put("RealtimeCityAir","RealtimeCityAir");
//        ArrayNode arrayNode = objectMapper.createArrayNode();
//        arrayNode.add("PM10");
//        arrayNode.add("PM25");
//        ond.set("row", arrayNode);
//        String json = ond.toString();
//
//        System.out.println(json);
//        RowResponseDto rowResponseDto = objectMapper.readValue(json, RowResponseDto.class);

        return objectMapper.readValue(objectNode, ApiResponseDto.class);
    }
}

