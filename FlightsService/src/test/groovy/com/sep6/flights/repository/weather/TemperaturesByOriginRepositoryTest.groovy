package com.sep6.flights.repository.weather

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.util.stream.Collectors

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class TemperaturesByOriginRepositoryTest extends Specification {

    @Autowired(required = true)
    private TemperaturesByOriginRepository repository

    def "test getTemperaturesAtOrigin"() {
        given:
        def result = repository.getTemperaturesAtOrigin("JFK")
        def dirtyData = result.stream().filter({ x -> x.getOrigin() == null || x.getOrigin() != "JFK" }).collect(Collectors.toList())

        expect:
        !result.empty
        dirtyData == null || dirtyData.empty
    }

    def "test getDailyMeanTemperaturesPerOrigin"() {
        given:
        def result = repository.getDailyMeanTemperaturesPerOrigin()
        def dirtyData = result.stream().filter({ x -> x.getOrigin() == null }).collect(Collectors.toList())
        def origins = result.stream().map({ x -> x.getOrigin() }).collect(Collectors.toSet())

        expect:
        !result.empty
        dirtyData == null || dirtyData.empty
        origins.size() == 3
    }

    def "test getDailyTemperatureMeanAtOrigin"() {
        given:
        def result = repository.getTemperaturesAtOrigin("JFK")
        def dirtyData = result.stream().filter({ x -> x.getOrigin() == null || x.getOrigin() != "JFK" }).collect(Collectors.toList())

        expect:
        !result.empty
        dirtyData == null || dirtyData.empty
    }
}
