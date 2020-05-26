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
@NamedQuery(name = "MeanDepartureDelay.getMeanDepartureDelay",
        query = "select new com.sep6.flights.model.flight.MeanDepartureDelay( f.origin, round(avg(f.dep_delay), 2) )" +
                " from Flight as f" +
                " group by f.origin")
public class MeanDepartureDelay {

    @Id
    private String origin;
    private double minutes;

}