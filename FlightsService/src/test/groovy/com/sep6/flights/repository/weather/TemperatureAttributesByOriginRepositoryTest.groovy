package com.sep6.flights.repository.weather

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.util.stream.Collectors

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class TemperatureAttributesByOriginRepositoryTest extends Specification {

    @Autowired(required=true)
    private TemperatureAttributesByOriginRepository repository

    def "test getAllTemperatureAttributes"() {
        given:
        def result = repository.getAllTemperatureAttributes()
        def dirtyData = result.stream().filter({ x -> x.getOrigin() == null }).collect(Collectors.toList())
        def origins = result.stream().map({ x -> x.getOrigin() }).collect(Collectors.toSet())

        expect:
        !result.empty
        dirtyData == null || dirtyData.empty
        origins.size() == 3
    }
}
