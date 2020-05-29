package com.sep6.flights.repository.weather;

import com.sep6.flights.model.weather.TemperatureAttributesByOrigin;
import com.sep6.flights.model.weather.TemperaturesByOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureAttributesByOriginRepository extends JpaRepository<TemperatureAttributesByOrigin, Long> {

    List<TemperatureAttributesByOrigin> getAllTemperatureAttributes();
}
