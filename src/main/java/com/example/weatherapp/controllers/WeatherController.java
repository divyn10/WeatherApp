package com.example.weatherapp.controllers;
import com.example.weatherapp.services.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }
    @GetMapping("")
    public String getWeather(@RequestParam("q") String query) throws JsonProcessingException {
        return weatherService.getWeather(query);
    }
}
