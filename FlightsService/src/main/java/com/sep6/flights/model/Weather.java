package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
public class Weather {

    @Id
    private Long id;
    private String origin;
    private int year;
    private int month;
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
    private Date time_hour;

}
