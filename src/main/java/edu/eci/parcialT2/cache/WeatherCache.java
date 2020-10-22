package edu.eci.parcialT2.cache;

import org.springframework.stereotype.Service;

@Service("WeatherCache")
public interface WeatherCache {
    void save (String name, String json);
    boolean isSave(String name);
    boolean isAlive(String name);
    String load(String name);
}
