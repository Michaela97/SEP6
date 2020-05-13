package com.sep6.flights.service;

import com.sep6.flights.model.weather.WeatherObservationsByOrigin;
import com.sep6.flights.repository.weather.WeatherObservationsByOriginRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherService {

    private final WeatherObservationsByOriginRepository weatherObservationsByOriginRepository;

    public WeatherService(WeatherObservationsByOriginRepository weatherObservationsByOriginRepository) {
        this.weatherObservationsByOriginRepository = weatherObservationsByOriginRepository;
    }

    @GetMapping("/getNumberOfWeatherObservationsByOrigin")
    public List<WeatherObservationsByOrigin> getNumberOfWeatherObservationsByOrigin() {
        return weatherObservationsByOriginRepository.getNumberOfObservationsByOrigin();
    }

}
