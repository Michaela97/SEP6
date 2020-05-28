package com.sep6.flights.model.flight

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.flight.FlightDestinationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class FlightDestinationTest extends Specification {

    @Autowired(required = true)
    private FlightDestinationRepository repository


    def "test get top destination from JFK"() {
        given:
        String origin = "JFK"

        when:
        def result = repository.getNoOfFlightsByDestination(origin, PageRequest.of(0, 10))

        then:
        assert !result.isEmpty()
        assert result.size() == 10
    }

    def "test get top destination from EWR"() {
        given:
        String origin = "EWR"

        when:
        def result = repository.getNoOfFlightsByDestination(origin, PageRequest.of(0, 10))

        then:
        assert !result.isEmpty()
        assert result.size() == 10
    }

    def "test get top destination from LGA"() {
        given:
        String origin = "LGA"

        when:
        def result = repository.getNoOfFlightsByDestination(origin, PageRequest.of(0, 10))

        then:
        assert !result.isEmpty()
        assert result.size() == 10
    }

}
