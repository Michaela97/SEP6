package com.sep6.flights.repository.weather;

import com.sep6.flights.model.weather.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
