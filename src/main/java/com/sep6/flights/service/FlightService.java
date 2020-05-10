package com.sep6.flights.service;

import com.sep6.flights.model.FlightsCountByMonth;
import com.sep6.flights.repository.FlightRepository;
import com.sep6.flights.repository.FlightsCountByMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightsCountByMonthRepository flightsCountByMonthRepository;

    @GetMapping("/getTotalNumberOfFlights")
    @ResponseBody
    public List<FlightsCountByMonth> getTotalNumberOfFlights() {
        return flightsCountByMonthRepository.getCount();
    }
}
