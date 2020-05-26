package com.sep6.flights.model.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "ManufacturersWithPlanes.getManufacturersWithMoreThanTwoHundredPlanes",
        query = "select new com.sep6.flights.model.plane.ManufacturersWithPlanes( p.manufacturer, count(p.tailnum) )" +
                " from Plane as p" +
                " group by p.manufacturer" +
                " having count(p.tailnum) > 200")
public class ManufacturersWithPlanes {

    @Id
    private String manufacturer;
    private long countOfPlanes;

}