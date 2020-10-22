package edu.eci.parcialT2.cache.impl;

import edu.eci.parcialT2.cache.WeatherCache;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("WeatherCacheImpl")
public class WeatherCacheImpl implements WeatherCache {

    HashMap<String,String> weatherbyname = new  HashMap<String,String>();
    HashMap<String,Long> weatherstime = new HashMap<String,Long>();

    @Override
    public void save(String name, String json) {
        weatherbyname.put(name, json);
        weatherstime.put(name,System.currentTimeMillis());
    }

    @Override
    public boolean isSave(String name) {
        return weatherbyname.containsKey(name);
    }

    @Override

    public String load(String name) {
        String weather = weatherbyname.get(name);
        return weather;
    }

    @Override
    public boolean isAlive(String name) {

        long timeLoad =( System.currentTimeMillis()-weatherstime.get(name))/1000;

        if (timeLoad>300){
            weatherbyname.remove(name);
            weatherstime.remove(name);
            return false;
        }
        return true;
    }
}