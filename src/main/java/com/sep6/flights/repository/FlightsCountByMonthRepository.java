package com.sep6.flights.repository;

import com.sep6.flights.model.FlightsCountByMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsCountByMonthRepository extends JpaRepository<FlightsCountByMonth, Integer> {

    List<FlightsCountByMonth> getCount();


}
