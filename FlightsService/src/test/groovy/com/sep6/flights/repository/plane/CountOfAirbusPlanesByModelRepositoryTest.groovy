package com.sep6.flights.repository.plane

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.flight.FlightDestinationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class CountOfAirbusPlanesByModelRepositoryTest extends Specification {

    @Autowired(required=true)
    private CountOfAirbusPlanesByModelRepository repository

    def "test countAirbusPlanesByModel"() {
        given:
        def result = repository.countAirbusPlanesByModel()

        expect:
        !result.empty
        result.size() == 13
    }


}
