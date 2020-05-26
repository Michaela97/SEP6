package com.sep6.flights.repository.flight

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class MeanArrivalDelayRepositoryTest extends Specification {

    @Autowired(required=true)
    private MeanArrivalDelayRepository repository


    def "test GetMeanArrivalDelay"() {
        given:
        def result = repository.getMeanArrivalDelay()

        expect:
        !result.empty
        result.size() == 3
    }
}
