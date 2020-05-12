package com.sep6.flights.model.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
