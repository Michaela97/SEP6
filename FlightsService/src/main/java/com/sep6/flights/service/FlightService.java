package com.sep6.flights.service;

import com.sep6.flights.model.flight.FlightDestination;
import com.sep6.flights.model.flight.FlightsCountByMonth;
import com.sep6.flights.repository.flight.FlightDestinationRepository;
import com.sep6.flights.repository.flight.FlightRepository;
import com.sep6.flights.repository.flight.FlightsCountByMonthRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightsCountByMonthRepository flightsCountByMonthRepository;
    private final FlightDestinationRepository flightDestinationRepository;

    public FlightService(FlightRepository flightRepository, FlightsCountByMonthRepository flightsCountByMonthRepository, FlightDestinationRepository flightDestinationRepository) {
        this.flightRepository = flightRepository;
        this.flightsCountByMonthRepository = flightsCountByMonthRepository;
        this.flightDestinationRepository = flightDestinationRepository;
    }

    @GetMapping("/getTotalNumberOfFlights")
    public List<FlightsCountByMonth> getTotalNumberOfFlights() {
        return flightsCountByMonthRepository.getCount();
    }

    @GetMapping("/getTotalNumberOfFlightsFromJFK")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromJFK() {
        return flightsCountByMonthRepository.getCountFromJFK();
    }

    @GetMapping("/getTotalNumberOfFlightsFromLGA")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromLGA() {
        return flightsCountByMonthRepository.getCountFromLGA();
    }

    @GetMapping("/getTotalNumberOfFlightsFromEWR")
    public List<FlightsCountByMonth> getTotalNumberOfFlightsFromEWR() {
        return flightsCountByMonthRepository.getCountFromEWR();
    }

    @GetMapping("/getTopTenDestinations")
    public List<FlightDestination> getTopTenDestinations() {
        return flightDestinationRepository.getNoOfFlightsByDestination(PageRequest.of(0,10));
    }

    @GetMapping("/deployTest")
    public String test() {
        return "Hello! You have deployed it successfully :D";
    }
}
