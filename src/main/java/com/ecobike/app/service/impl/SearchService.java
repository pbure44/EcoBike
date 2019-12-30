package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.repository.impl.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final InputService inputService;
    private final BikeBuilderService bikeBuilderService;
    private final FileRepository fileRepository;
    private List<AbstractBike> bikeList;
    private LinearSearch linearSearch;

    public SearchService(InputService inputService, BikeBuilderService bikeBuilderService, FileRepository fileRepository) {
        this.inputService = inputService;
        this.bikeBuilderService = bikeBuilderService;
        this.fileRepository = fileRepository;
    }

    public void find() {
        search(bikeBuilderService.builder(inputService.findBikeType()));
    }

    private void search(AbstractBike bike){
        bikeList = FileRepository.getBIKES();
        linearSearch = new LinearSearch(bike,bikeList);
        linearSearch.linearSearch(bike);
    }
}
