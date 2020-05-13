package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.FlightDestination;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDestinationRepository extends JpaRepository<FlightDestination, String> {

    List<FlightDestination> getNoOfFlightsByDestination(Pageable pageable);


}
