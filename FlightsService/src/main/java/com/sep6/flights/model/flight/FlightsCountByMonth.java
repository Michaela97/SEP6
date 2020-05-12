package com.sep6.flights.model.flight;

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
@NamedQuery(name = "FlightsCountByMonth.getCount",
        query = "select new com.sep6.flights.model.flight.FlightsCountByMonth( f.month, count(f.id)) " +
                "from Flight as f group by f.month " +
                "order by f.month")
public class FlightsCountByMonth {

    @Id
    private int month;
    private long countOfFlights;

}
