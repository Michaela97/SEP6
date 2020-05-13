package com.sep6.flights.model.flight

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.flight.FlightDestinationRepository
import com.sep6.flights.repository.flight.FlightsCountByMonthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class FlightDestinationTest extends Specification {

    @Autowired(required=true)
    private FlightDestinationRepository repository

    def "test get count"() {
        when:
        def result = repository.getNoOfFlightsByDestination(PageRequest.of(0,10))

        then:
        assert !result.isEmpty()
        assert  result.size() == 10
    }

}
