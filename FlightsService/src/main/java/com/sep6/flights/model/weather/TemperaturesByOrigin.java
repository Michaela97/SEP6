package com.sep6.flights.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "TemperaturesByOrigin.getTemperaturesAtOrigin",
        query = "select new com.sep6.flights.model.weather.TemperaturesByOrigin(w.origin,w.year,w.month,w.day,w.hour,((w.temp-32)*5/9)) " +
                "from Weather as w where w.origin = :origin " +
                "order by (w.year,w.month,w.day,w.hour)")
@NamedQuery(name = "TemperaturesByOrigin.getDailyMeanTemperaturesPerOrigin",
        query = "select new com.sep6.flights.model.weather.TemperaturesByOrigin(w.origin,w.year,w.month,w.day,((avg(w.temp)-32)*5/9)) " +
                "from Weather as w " +
                "group by (w.origin,w.year,w.month,w.day) " +
                "order by (w.origin,w.year,w.month,w.day)")
@NamedQuery(name = "TemperaturesByOrigin.getDailyTemperatureMeanAtOrigin",
        query = "select new com.sep6.flights.model.weather.TemperaturesByOrigin(w.origin,w.year,w.month,w.day,((avg(w.temp)-32)*5/9)) " +
                "from Weather w " +
                "where w.origin = :origin " +
                "group by (w.origin,w.year,w.month,w.day)" +
                "order by (w.origin,w.year,w.month,w.day)")

public class TemperaturesByOrigin {

    @Id
    private String origin;
    private LocalDateTime timestamp;
    private double temperature;

    public TemperaturesByOrigin(String origin, int  year, int month, int day, int hour, double temperature) {
        this.origin = origin;
        this.timestamp = LocalDateTime.of(year,month,day,hour,0);
        this.temperature = temperature;
    }

    public TemperaturesByOrigin(String origin, int  year, int month, int day, double temperature) {
        this.origin = origin;
        this.timestamp = LocalDateTime.of(year,month,day,0,0);
        this.temperature = temperature;
    }
}