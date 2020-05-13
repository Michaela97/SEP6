package com.sep6.flights.model.flight

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.flight.FlightsCountByMonthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class FlightsCountByMonthTest extends Specification {


    @Autowired(required=true)
    private FlightsCountByMonthRepository repository


    def "test get count"() {
        when:
        def result = repository.getCount()

        then:
        assert !result.isEmpty()
        assert  result.size() == 12
    }

}
