package com.sep6.flights.model.repository;

import com.sep6.flights.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Long, Weather> {
}
