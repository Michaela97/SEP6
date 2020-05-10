package com.sep6.flights

import com.sep6.flights.model.repository.AirlineRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
class AirlineTest extends Specification {

    @Autowired
    private AirlineRepository airlineRepository



    def "test get all airlines"(){
        when:
        def allAirlines = airlineRepository.findAll()

        expect:
        !allAirlines.empty

    }
}
