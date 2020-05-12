package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
