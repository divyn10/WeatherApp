package com.example.weatherapp.thirdPartyClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherApiClient {

    @Value("${WEATHER_API_KEY}")
    private String api_key;

    @Value("${weatherapi.uriBase}")
    private String uriBase;

    private RestClient restClient = RestClient.create();

    public String getWeather(String query) throws JsonProcessingException {

        URI uri = UriComponentsBuilder.fromUriString(uriBase + "/current.json")
                .queryParam("q", query)
                .build()
                .toUri();

        ResponseEntity<String> result = restClient.get()
                .uri(uri)
                .header("key", api_key)
                .retrieve()
                .toEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String,Object>> typeRef =
                new TypeReference<HashMap<String,Object>>() {};

        HashMap<String,Object> o = mapper.readValue(result.getBody(), typeRef);

        return ((HashMap<String, HashMap<String, String>>)o.get("current")).get("condition").get("text");
    }
}
