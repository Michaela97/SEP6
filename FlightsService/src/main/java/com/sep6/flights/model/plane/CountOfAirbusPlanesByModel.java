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
@NamedQuery(name = "CountOfAirbusPlanesByModel.countAirbusPlanesByModel",
        query = """
                select new com.sep6.flights.model.plane.CountOfAirbusPlanesByModel( p.model, count(*)) 
                from Plane p 
                where p.manufacturer = 'AIRBUS INDUSTRIE' 
                group by p.model""")
public class CountOfAirbusPlanesByModel {

    @Id
    private String model;
    private long numberOfPlanes;

}