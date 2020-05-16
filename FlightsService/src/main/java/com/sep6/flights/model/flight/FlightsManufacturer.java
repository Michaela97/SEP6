package com.sep6.flights.model.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedNativeQuery(name = "FlightsManufacturer.getNoOfFlightsByManufacturer",
query = "SELECT p.manufacturer, count(*) as count_of_flights from flights as f JOIN planes as p ON f.tailnum = p.tailnum WHERE p.manufacturer in " +
        "(SELECT pl.manufacturer from planes as pl GROUP BY pl.manufacturer HAVING count(*) > 200) " +
        "GROUP BY p.manufacturer"
        , resultClass = FlightsManufacturer.class)
public class FlightsManufacturer {

    @Id
    private String manufacturer;
    private long countOfFlights;

}