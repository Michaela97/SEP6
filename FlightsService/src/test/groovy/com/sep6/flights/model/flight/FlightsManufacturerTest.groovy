package com.sep6.flights.model.flight

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.flight.FlightsCountByMonthRepository
import com.sep6.flights.repository.flight.FlightsManufacturerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class FlightsManufacturerTest extends Specification {

    @Autowired(required=true)
    private FlightsManufacturerRepository repository

    def "test get count by manufacturer"() {
        when:
        def result = repository.getNoOfFlightsByManufacturer()

        then:
        assert !result.isEmpty()
        assert  result.size() == 4
    }
}
