package com.sep6.flights.actuatorservice;

import com.sep6.flights.model.Airline;
import com.sep6.flights.model.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final AirlineRepository airlineRepository;

    public HelloWorldController(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/getAirlines")
    @ResponseBody
    public List<Airline> getAirlines() {
        return airlineRepository.findAll();
    }


}
