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
@NamedQuery(name = "MeanAirtime.getMeanAirtimeByOrigin",
        query = "select new com.sep6.flights.model.flight.MeanAirtime(f.origin, avg(f.air_time))" +
                " from Flight as f" +
                " group by f.origin")
public class MeanAirtime {

    @Id
    private String origin;
    private double meanAirtime;

}