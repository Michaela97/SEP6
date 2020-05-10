package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
public class Airline {

    @Id
    private Long id;
    private String carrier;
    private String name;

}



