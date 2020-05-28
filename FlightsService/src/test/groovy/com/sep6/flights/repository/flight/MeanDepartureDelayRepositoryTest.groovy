package com.sep6.flights.repository.flight

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class MeanDepartureDelayRepositoryTest extends Specification {

    @Autowired(required=true)
    private MeanDepartureDelayRepository repository


    def "test GetMeanDepartureDelay"() {
        given:
        def result = repository.getMeanDepartureDelay()

        expect:
        !result.empty
        result.size() == 3
    }
}
