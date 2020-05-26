package com.sep6.flights.repository.plane

import com.sep6.flights.Sep6Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class ManufacturersWithPlanesTest  extends Specification{


    @Autowired(required=true)
    private ManufacturersWithPlanesRepository repository

    def "test getManufacturersWithMoreThanTwoHundredPlanes"() {
        given:
        def result = repository.getManufacturersWithMoreThanTwoHundredPlanes()

        expect:
        !result.empty
        result.size() == 5
    }

}
