package com.weather_api.weather_call.WeatherPull;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponse {
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;
    private int cod;

    // Getters and setters
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
