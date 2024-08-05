package com.weather_api.weather_call;

import com.weather_api.weather_call.WeatherPull.WeatherResponse;

public interface WeatherService {

    WeatherResponse fetchWeatherDetail(String city);

}