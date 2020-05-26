package com.sep6.flights.repository.plane;

import com.sep6.flights.model.plane.CountOfAirbusPlanesByModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountOfAirbusPlanesByModelRepository extends JpaRepository<CountOfAirbusPlanesByModel, String> {

    List<CountOfAirbusPlanesByModel> countAirbusPlanesByModel();


}
