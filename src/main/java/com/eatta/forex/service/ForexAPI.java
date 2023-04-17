package com.eatta.forex.service;

import com.eatta.forex.data.dto.ForexAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ForexAPI {

    public static final String FOREX_API_HOST = "https://api.exchangerate.host/latest";
    private final RestTemplate restTemplate;

    public ForexAPI(RestTemplate template) {
        this.restTemplate = template;
    }

    public ForexAPIResponse callForexAPI(String base) {

        ForexAPIResponse postingResponse = null;
        try {
            ResponseEntity<ForexAPIResponse> apiResponse = restTemplate.getForEntity(FOREX_API_HOST + "?base=" + base, ForexAPIResponse.class);
            System.out.println("API response status: " + apiResponse.getStatusCode());
            System.out.println("API response -> body: " + apiResponse.getBody());
            postingResponse = apiResponse.getBody();
        } catch (Exception e) {
            System.out.println(">>> " + e + " " + e.getMessage());
        }
        return postingResponse;
    }

}