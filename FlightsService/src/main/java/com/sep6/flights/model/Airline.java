package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Airline {

    @Id
    private Long id;
    private String carrier;
    private String name;

}



