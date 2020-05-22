package com.sep6.flights.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    private Long id;
    private String origin;
    private int year;
    private int month;
    private int day;
    private int hour;
    private double temp;
    private double dewp;
    private double humid;
    private int wind_dir;
    private double wind_speed;
    private double wind_gust;
    private int precip;
    private double pressure;
    private int visib;
    private LocalDateTime time_hour;

}
