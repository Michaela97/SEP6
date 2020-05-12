package com.sep6.flights.repository.plane;

import com.sep6.flights.model.plane.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long>  {
}
