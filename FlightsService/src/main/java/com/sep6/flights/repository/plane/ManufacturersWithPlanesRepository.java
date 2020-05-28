package com.sep6.flights.repository.plane;

import com.sep6.flights.model.plane.ManufacturersWithPlanes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturersWithPlanesRepository extends JpaRepository<ManufacturersWithPlanes, String> {

    List<ManufacturersWithPlanes> getManufacturersWithMoreThanTwoHundredPlanes();


}
