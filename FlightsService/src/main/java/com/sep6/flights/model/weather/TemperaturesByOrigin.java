package com.sep6.flights.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "TemperaturesByOrigin.getTemperaturesAtOrigin",
        query = "select new com.sep6.flights.model.weather.TemperaturesByOrigin( w.origin,w.time_hour,((w.temp-32)*5/9)) " +
                "from Weather as w where w.origin = :origin " +
                "order by w.time_hour")
public class TemperaturesByOrigin {

    @Id
    private String origin;
    private LocalDateTime timestamp;
    private double temperature;

}