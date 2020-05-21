package com.sep6.flights.service;

import com.sep6.flights.model.flight.FlightDestination;
import com.sep6.flights.model.flight.FlightsCountByMonth;
import com.sep6.flights.model.flight.FlightsManufacturer;
import com.sep6.flights.repository.flight.FlightDestinationRepository;
import com.sep6.flights.repository.flight.FlightRepository;
import com.sep6.flights.repository.flight.FlightsCountByMonthRepository;
import com.sep6.flights.repository.flight.FlightsManufacturerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightService {

    private final FlightsCountByMonthRepository flightsCountByMonthRepository;
    private final FlightDestinationRepository flightDestinationRepository;
    private final FlightsManufacturerRepository flightsManufacturerRepository;

    public FlightService(FlightsCountByMonthRepository flightsCountByMonthRepository, FlightDestinationRepository flightDestinationRepository, FlightsManufacturerRepository flightsManufacturerRepository) {
        this.flightsCountByMonthRepository = flightsCountByMonthRepository;
        this.flightDestinationRepository = flightDestinationRepository;
        this.flightsManufacturerRepository = flightsManufacturerRepository;
    }

    @GetMapping("/getTotalNumberOfFlights")
    public List<FlightsCountByMonth> getTotalNumberOfFlights() {
        return flightsCountByMonthRepository.getCount();
    }

    @GetMapping("/getTotalNumberOfFlightsFromJFK")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromJFK() {
        return flightsCountByMonthRepository.getCountFromOrigin("JFK");
    }

    @GetMapping("/getTotalNumberOfFlightsFromLGA")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromLGA() {
        return flightsCountByMonthRepository.getCountFromOrigin("LGA");
    }

    @GetMapping("/getTotalNumberOfFlightsFromEWR")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromEWR() {
        return flightsCountByMonthRepository.getCountFromOrigin("EWR");
    }

    @GetMapping("/getTopTenDestinationsFromJFK")
    public List<FlightDestination> getTopTenDestinationsFromJFK() {
        return flightDestinationRepository.getNoOfFlightsByDestination("JFK", PageRequest.of(0,10));
    }

    @GetMapping("/getTopTenDestinationsFromLGA")
    public List<FlightDestination> getTopTenDestinationsFromLGA() {
        return flightDestinationRepository.getNoOfFlightsByDestination("LGA", PageRequest.of(0,10));
    }

    @GetMapping("/getTopTenDestinationsFromEWR")
    public List<FlightDestination> getTopTenDestinationsFromEWR() {
        return flightDestinationRepository.getNoOfFlightsByDestination("EWR", PageRequest.of(0,10));
    }

    @GetMapping("/getFlightsByManufacturer")
    public List<FlightsManufacturer> getFlightsByManufacturer() {
        return flightsManufacturerRepository.getNoOfFlightsByManufacturer();
    }

}
