package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.MeanArrivalDelay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeanArrivalDelayRepository extends JpaRepository<MeanArrivalDelay, String> {

    List<MeanArrivalDelay> getMeanArrivalDelay();


}
