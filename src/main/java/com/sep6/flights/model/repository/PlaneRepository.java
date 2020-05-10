package com.sep6.flights.model.repository;

import com.sep6.flights.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long>  {
}
