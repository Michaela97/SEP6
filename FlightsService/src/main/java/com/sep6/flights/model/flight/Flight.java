package com.sep6.flights.model.flight;


import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    private Long id;
    private int year;
    private int month;
    private int day;
    private int dep_time;
    private int arr_time;
    private int arr_delay;
    @Column(nullable = true)
    private String carrier;
    @Column(nullable = true)
    private String tailnum;
    private int flight;
    @Column(nullable = true)
    private String origin;
    @Column(nullable = true)
    private String dest;
    @Nullable
    private int air_time;
    private int distance;
    private int hour;
    private int minute;

}

