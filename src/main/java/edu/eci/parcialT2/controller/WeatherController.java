package edu.eci.parcialT2.controller;

import edu.eci.parcialT2.service.HttpConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weatherfinder")
public class WeatherController {

    @Autowired
    @Qualifier("HttpConnectionServiceImpl")
    HttpConnectionService ht;

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherByName(@PathVariable(name = "name") String nombre) {
        try {

            return new ResponseEntity<>(ht.weatherByCity(nombre), HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }

}
