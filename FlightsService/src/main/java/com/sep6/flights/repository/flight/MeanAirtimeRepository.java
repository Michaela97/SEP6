package com.sep6.flights.repository.flight;

import com.sep6.flights.model.flight.MeanAirtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeanAirtimeRepository extends JpaRepository<MeanAirtime, String> {

    List<MeanAirtime> getMeanAirtimeByOrigin();


}
