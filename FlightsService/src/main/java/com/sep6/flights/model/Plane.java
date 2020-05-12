package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
public class Plane {

    @Id
    private Long id;
    private String tailnum;
    private int year;
    private String type;
    private String manufacturer;
    private String model;
    private int engines;
    private int seats;
    private double speed;
    private String engine;
}
