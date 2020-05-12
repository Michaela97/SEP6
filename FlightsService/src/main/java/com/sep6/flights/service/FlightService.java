package com.sep6.flights.service;

import com.sep6.flights.model.FlightsCountByMonth;
import com.sep6.flights.repository.FlightRepository;
import com.sep6.flights.repository.FlightsCountByMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightService {

    private final FlightRepository flightRepository;

    private final FlightsCountByMonthRepository flightsCountByMonthRepository;

    public FlightService(FlightRepository flightRepository, FlightsCountByMonthRepository flightsCountByMonthRepository) {
        this.flightRepository = flightRepository;
        this.flightsCountByMonthRepository = flightsCountByMonthRepository;
    }

    @GetMapping("/getTotalNumberOfFlights")
    public List<FlightsCountByMonth> getTotalNumberOfFlights() {
        return flightsCountByMonthRepository.getCount();
    }

    @GetMapping("/deployTest")
    public String test() {
        return "Hello! You have deployed it successfully :D";
    }
}
