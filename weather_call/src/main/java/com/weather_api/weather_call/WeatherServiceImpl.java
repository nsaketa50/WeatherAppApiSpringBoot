package com.weather_api.weather_call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather_api.weather_call.WeatherPull.WeatherResponse;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public WeatherResponse fetchWeatherDetail(String city) {

        // OpenWeatherMap API URL with API key (Replace with your own API key)
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city
                + "&appid=bc9b931ab1f44589ff5281a8fba75f8f";

        // Response Entity
        // RestTemplate is a Spring class used to make HTTP requests and handle the
        // responses. It's a synchronous client-side HTTP access tool.
        // getForEntity
        // Send an HTTP GET request to an external API using RestTemplate.
        // Capture the entire HTTP response, including status and body, using
        // ResponseEntity.
        // Check the response status code to ensure the request was successful.
        // Extract and process data from the response body, handling cases where the
        // body might be null.
        // Log relevant information for debugging or display purposes.
        ResponseEntity<WeatherResponse> responseEntity = restTemplate.getForEntity(url, WeatherResponse.class);

        // Log the response status code
        System.out.println("Response status code: " + responseEntity.getStatusCode());

        // Log the response body
        WeatherResponse weatherResponse = responseEntity.getBody();
        if (weatherResponse != null) {
            System.out.println("Weather information for " + city + ":");
            System.out.println("Temperature: " + weatherResponse.getMain().getTemp());
            System.out.println("Feels Like: " + weatherResponse.getMain().getFeels_like());
            System.out.println("Min Temperature: " + weatherResponse.getMain().getTemp_min());
            double minToKelvin = weatherResponse.getMain().getTemp_min();
            double minTempInFahrenheit = ((minToKelvin - 273.15) * 9 / 5) + 32;
            System.out.println("In Farh iss ---------" + minTempInFahrenheit);
            System.out.println("Max Temperature: " + weatherResponse.getMain().getTemp_max());
            System.out.println("Humidity: " + weatherResponse.getMain().getHumidity());
            System.out.println("Weather: " + weatherResponse.getWeather().get(0).getMain());
            System.out.println("Wind Speed: " + weatherResponse.getWind().getSpeed());
            System.out.println("Sunrise: " + weatherResponse.getSys().getSunrise());
            System.out.println("Sunset: " + weatherResponse.getSys().getSunset());
        }

        return weatherResponse;
    }
}
