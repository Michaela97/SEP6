package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.MeanDepartureDelay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeanDepartureDelayRepository extends JpaRepository<MeanDepartureDelay, String> {

    List<MeanDepartureDelay> getMeanDepartureDelay();


}
