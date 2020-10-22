package edu.eci.parcialT2.service.impl;

import edu.eci.parcialT2.cache.WeatherCache;
import edu.eci.parcialT2.service.HttpConnectionService;
import edu.eci.parcialT2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("WeatherServiceImpl")
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    @Qualifier("HttpConnectionServiceImpl")
    HttpConnectionService hcs;


    @Autowired
    @Qualifier("WeatherCacheImpl")
    WeatherCache wc;
    @Override
    public String getWeatherByCity(String name) throws IOException {
        if(!wc.isSave(name)){
            wc.save(name, hcs.weatherByCity(name));
        }
        else {
            if(!wc.isAlive(name)){
                wc.save(name, hcs.weatherByCity(name));
            }
        }
        return wc.load(name);
    }
}
