package com.weather_api.weather_call;

import org.springframework.web.bind.annotation.RestController;

import com.weather_api.weather_call.WeatherPull.WeatherResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherServiceImpl;

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        WeatherResponse weatherResponse;
        weatherResponse = weatherServiceImpl.fetchWeatherDetail(city);
        return weatherResponse;
    }

}
