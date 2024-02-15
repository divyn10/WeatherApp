package com.example.weatherapp.services;

import com.example.weatherapp.thirdPartyClients.WeatherApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final WeatherApiClient weatherApiClient;
    public WeatherService(WeatherApiClient weatherApiClient){
        this.weatherApiClient = weatherApiClient;
    }
    public String getWeather(String query) throws JsonProcessingException {
        return weatherApiClient.getWeather(query);
    }
}
