package com.sep6.flights.service;

import com.sep6.flights.model.flight.*;
import com.sep6.flights.repository.flight.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightService {

    private final FlightsCountByMonthRepository flightsCountByMonthRepository;
    private final FlightDestinationRepository flightDestinationRepository;
    private final FlightsManufacturerRepository flightsManufacturerRepository;
    private final MeanArrivalDelayRepository meanArrivalDelayRepository;
    private final MeanDepartureDelayRepository meanDepartureDelayRepository;
    private final MeanAirtimeRepository meanAirtimeRepository;

    public FlightService(FlightsCountByMonthRepository flightsCountByMonthRepository, FlightDestinationRepository flightDestinationRepository, FlightsManufacturerRepository flightsManufacturerRepository, MeanArrivalDelayRepository meanArrivalDelayRepository, MeanDepartureDelayRepository meanDepartureDelayRepository, MeanAirtimeRepository meanAirtimeRepository) {
        this.flightsCountByMonthRepository = flightsCountByMonthRepository;
        this.flightDestinationRepository = flightDestinationRepository;
        this.flightsManufacturerRepository = flightsManufacturerRepository;
        this.meanArrivalDelayRepository = meanArrivalDelayRepository;
        this.meanDepartureDelayRepository = meanDepartureDelayRepository;
        this.meanAirtimeRepository = meanAirtimeRepository;
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

    @GetMapping("/getMeanDepartureDelay")
    public List<MeanDepartureDelay> getMeanDepartureDelay() {
        return meanDepartureDelayRepository.getMeanDepartureDelay();
    }

    @GetMapping("/getMeanArrivalDelay")
    public List<MeanArrivalDelay> getMeanArrivalDelay() {
        return meanArrivalDelayRepository.getMeanArrivalDelay();
    }

    @GetMapping("/getMeanAirtime")
    public List<MeanAirtime> getMeanAirtime() {
        return meanAirtimeRepository.getMeanAirtimeByOrigin();
    }

}
