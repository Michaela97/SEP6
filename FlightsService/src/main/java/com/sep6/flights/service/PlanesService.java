package com.sep6.flights.service;

import com.sep6.flights.model.plane.CountOfAirbusPlanesByModel;
import com.sep6.flights.repository.plane.CountOfAirbusPlanesByModelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlanesService {

    private CountOfAirbusPlanesByModelRepository repository;

    public PlanesService(CountOfAirbusPlanesByModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countOfAirbusPlanesByModelList")
    public List<CountOfAirbusPlanesByModel> countOfAirbusPlanesByModelList() {
        return repository.countAirbusPlanesByModel();
    }


}
