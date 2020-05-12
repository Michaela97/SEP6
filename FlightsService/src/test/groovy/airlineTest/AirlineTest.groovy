package airlineTest

import com.sep6.flights.Sep6Application
import com.sep6.flights.repository.AirlineRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = Sep6Application.class)
class AirlineTest extends Specification {

    @Autowired(required=true)
    private AirlineRepository airlineRepository


    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }


    def "test get all airlines"(){
        when:
        def allAirlines = airlineRepository.findAll()

        then:
        assert !allAirlines.empty

    }
}
