package com.example.demo.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@Service
@RequiredArgsConstructor
public class AirService {

    @Transactional
    public String getAirBad() throws IOException {
        String KEY = "72576146456879753132344661637646";
        String TYPE = "json";
        String SERVICE = "RealtimeCityAir";
        Integer START_INDEX = 1;
        Integer END_INDEX = 1;
        String MSRRGN_NM = "동남권";
        String MSRSTE_NM = "강동구";

        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
        urlBuilder.append("/" + URLEncoder.encode(KEY, "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(TYPE, "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(SERVICE, "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(String.valueOf(START_INDEX), "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(String.valueOf(END_INDEX), "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(MSRRGN_NM, "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode(MSRSTE_NM, "UTF-8"));
        URL url = new URL(urlBuilder.toString());


        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-type", "application/xml");
        conn.setRequestMethod("GET");
//        System.out.println(conn);


        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
//        System.out.println(rd);

        String reasult ="";
        String line="";
        while ((line = rd.readLine()) != null) {
            reasult = reasult.concat(line);
        }

//        System.out.println(reasult);
        //close는 작업종료 알림, 안닫으면 자원 누수됨
        rd.close();
        //http를 종료하는 이유는 서버 -> 클라이언트로 응답을 계속 기다리게 되므로 서버 자원낭비.
        conn.disconnect();
//        System.out.println(reasult);
        return reasult;
    }
}