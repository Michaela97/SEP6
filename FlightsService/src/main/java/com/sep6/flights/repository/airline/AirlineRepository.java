package com.sep6.flights.repository.airline;

import com.sep6.flights.model.airline.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {


}
