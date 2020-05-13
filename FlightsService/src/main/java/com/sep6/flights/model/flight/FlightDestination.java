package com.sep6.flights.model.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "FlightDestination.getNoOfFlightsByDestination",
        query = "select new com.sep6.flights.model.flight.FlightDestination( f.dest, count(f.id) as countOfFlights) " +
                "from Flight as f  " +
                "group by f.dest " +
                "order by countOfFlights DESC")
public class FlightDestination {

    @Id
    private String destination;
    private long countOfFlights;


}