package com.sep6.flights.service;

import com.sep6.flights.model.plane.CountOfAirbusPlanesByModel;
import com.sep6.flights.model.plane.ManufacturersWithPlanes;
import com.sep6.flights.repository.plane.CountOfAirbusPlanesByModelRepository;
import com.sep6.flights.repository.plane.ManufacturersWithPlanesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlanesService {

    private CountOfAirbusPlanesByModelRepository airbusPlanesByModelRepository;
    private ManufacturersWithPlanesRepository manufacturersWithPlanesRepository;

    public PlanesService(CountOfAirbusPlanesByModelRepository repository, ManufacturersWithPlanesRepository manufacturersWithPlanesRepository) {
        this.airbusPlanesByModelRepository = repository;
        this.manufacturersWithPlanesRepository = manufacturersWithPlanesRepository;
    }

    @GetMapping("/countOfAirbusPlanesByModelList")
    public List<CountOfAirbusPlanesByModel> countOfAirbusPlanesByModelList() {
        return airbusPlanesByModelRepository.countAirbusPlanesByModel();
    }

    @GetMapping("/getManufacturersWithMoreThanTwoHundredPlanes")
    public List<ManufacturersWithPlanes> getManufacturersWithMoreThanTwoHundredPlanes() {
        return manufacturersWithPlanesRepository.getManufacturersWithMoreThanTwoHundredPlanes();
    }


}
