package com.sep6.flights.repository.weather;

import com.sep6.flights.model.weather.TemperaturesByOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperaturesByOriginRepository extends JpaRepository<TemperaturesByOrigin, Long> {

    List<TemperaturesByOrigin> getTemperaturesAtOrigin(String origin);

    List<TemperaturesByOrigin> getDailyMeanTemperaturesPerOrigin();

    List<TemperaturesByOrigin> getDailyTemperatureMeanAtOrigin(String origin);
}
