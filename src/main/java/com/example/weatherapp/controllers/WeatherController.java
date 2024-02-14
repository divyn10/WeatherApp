package com.example.weatherapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/test")
    public String getWeather(){
        return "this is a just a test api response";
    }

}
