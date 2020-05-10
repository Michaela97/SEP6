package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
public class Airport {

    @Id
    private Long id;
    private String faa;
    private String name;
    private double last;
    private double lon;
    private int alt;
    private int tz;
    private String dst;
    private String tzone;


}
