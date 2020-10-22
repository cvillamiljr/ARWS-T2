package edu.eci.parcialT2.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("WeatherService")
public interface WeatherService {
    String getWeatherByCity(String name) throws IOException;
}
