package com.sep6.flights.model.repository;

import com.sep6.flights.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Long, Airline> {


}
