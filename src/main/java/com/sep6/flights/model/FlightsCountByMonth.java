package com.sep6.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
@NamedQuery(name = "FlightsCountByMonth.getCount",
        query = "select new com.sep6.flights.model.FlightsCountByMonth( f.month, count(f.id)) " +
                "from Flight as f group by f.month" +
                "order by f.month")
public class FlightsCountByMonth {

    @Id
    private int month;
    private long countOfFlights;

}
