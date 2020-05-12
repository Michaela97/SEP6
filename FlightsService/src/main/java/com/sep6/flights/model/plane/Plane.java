package com.sep6.flights.model.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
