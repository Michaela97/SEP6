package com.sep6.flights.service;

import com.sep6.flights.model.weather.WeatherObservationsByOrigin;
import com.sep6.flights.repository.weather.WeatherObservationsByOriginRepository;
import com.sep6.flights.model.weather.TemperaturesByOrigin;
import com.sep6.flights.repository.weather.TemperaturesByOriginRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherService {

    private final WeatherObservationsByOriginRepository weatherObservationsByOriginRepository;
    private final TemperaturesByOriginRepository temperaturesByOriginRepository;

    public WeatherService(WeatherObservationsByOriginRepository weatherObservationsByOriginRepository,TemperaturesByOriginRepository temperaturesByOriginRepository) {
        this.weatherObservationsByOriginRepository = weatherObservationsByOriginRepository;
        this.temperaturesByOriginRepository = temperaturesByOriginRepository;
    }

    @GetMapping("/getNumberOfWeatherObservationsByOrigin")
    public List<WeatherObservationsByOrigin> getNumberOfWeatherObservationsByOrigin() {
        return weatherObservationsByOriginRepository.getNumberOfObservationsByOrigin();
    }

    @GetMapping("/getTemperaturesAtJFK")
    public List<TemperaturesByOrigin> getTemperaturesAtJFK() {
        return temperaturesByOriginRepository.getTemperaturesAtOrigin("JFK");
    }

    @GetMapping("/getDailyTemperatureMeanByOrigin")
    public List<TemperaturesByOrigin> getDailyTemperatureMeanPerOrigin() {
        return temperaturesByOriginRepository.getDailyMeanTemperaturesPerOrigin();
    }
}