package com.sep6.flights.repository.weather

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.util.stream.Collectors

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class WeatherObservationsByOriginRepositoryTest extends Specification {

    @Autowired(required=true)
    private WeatherObservationsByOriginRepository repository

    def "test getNumberOfObservationsByOrigin"() {
        given:
        def result = repository.getNumberOfObservationsByOrigin()
        def dirtyData = result.stream().filter({ x -> x.getOrigin() == null}).collect(Collectors.toList())

        expect:
        !result.empty
        result.size() == 3
        dirtyData == null || dirtyData.empty
    }
}
