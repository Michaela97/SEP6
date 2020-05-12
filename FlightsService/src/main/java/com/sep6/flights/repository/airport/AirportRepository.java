package com.sep6.flights.repository.airport;

import com.sep6.flights.model.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long>  {
}
