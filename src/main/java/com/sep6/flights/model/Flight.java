package com.sep6.flights.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
public class Flight {

    @Id
    private Long id;
    private int year;
    private int month;
    private int day;
    private int dep_time;
    private int arr_time;
    private int arr_delay;
    private String carrier;
    private String tailnum;
    private int flight;
    private String origin;
    private String dest;
    private int air_time;
    private int distance;
    private int hour;
    private int minute;



}
