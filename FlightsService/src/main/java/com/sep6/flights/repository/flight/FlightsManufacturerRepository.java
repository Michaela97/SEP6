package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.FlightsManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsManufacturerRepository extends JpaRepository<FlightsManufacturer, String> {

    List<FlightsManufacturer> getNoOfFlightsByManufacturer();


}
