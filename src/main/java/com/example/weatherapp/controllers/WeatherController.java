package com.example.weatherapp.controllers;
import com.example.weatherapp.services.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    WeatherService weatherService;
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }
    @GetMapping("")
    public String getWeather(){
        return weatherService.getWeather();
    }
}
