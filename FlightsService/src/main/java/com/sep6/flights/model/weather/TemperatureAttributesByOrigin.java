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
@NamedQuery(name = "TemperatureAttributesByOrigin.getAllTemperatureAttributes",
        query = "select new com.sep6.flights.model.weather.TemperatureAttributesByOrigin(w.origin,w.year,w.month,w.day,w.hour,((w.temp-32)*5/9),((w.dewp-32)*5/9)) " +
                "from Weather as w " +
                "order by (w.origin,w.year,w.month,w.day,w.hour)")
public class TemperatureAttributesByOrigin {

    @Id
    private String origin;
    private LocalDateTime timestamp;
    private Double temperature;
    private Double dewPoint;

    public TemperatureAttributesByOrigin(String origin, int year, int month, int day, int hour, Double temperature, Double dewPoint) {
        this.origin = origin;
        this.timestamp = LocalDateTime.of(year,month,day,hour,0);
        this.temperature = temperature;
        this.dewPoint = dewPoint;
    }
}