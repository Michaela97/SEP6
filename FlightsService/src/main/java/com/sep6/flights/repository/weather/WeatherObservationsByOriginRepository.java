package com.sep6.flights.repository.weather;

import com.sep6.flights.model.weather.WeatherObservationsByOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherObservationsByOriginRepository extends JpaRepository<WeatherObservationsByOrigin, Long> {
    List<WeatherObservationsByOrigin> getNumberOfObservationsByOrigin();
}
