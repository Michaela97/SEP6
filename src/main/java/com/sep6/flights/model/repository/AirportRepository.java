package com.sep6.flights.model.repository;

import com.sep6.flights.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long>  {
}
