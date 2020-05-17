package com.sep6.flights.model.weather;

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
@NamedQuery(name = "WeatherObservationsByOrigin.getNumberOfObservationsByOrigin",
        query = "select new com.sep6.flights.model.weather.WeatherObservationsByOrigin( w.origin, count(*)) " +
                "from Weather as w group by w.origin " +
                "order by w.origin")

public class WeatherObservationsByOrigin {

    @Id
    private String origin;
    private long countOfObservations;

}
