package com.ecobike.app.service.impl;

import com.ecobike.app.repository.IFileRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final IFileRepository fileRepository;
    private final LinearSearch linearSearch;
    private final InputService inputService;
    private final BikeBuilderService bikeBuilderService;

    public SearchService(IFileRepository fileRepository, LinearSearch linearSearch, InputService inputService, BikeBuilderService bikeBuilderService) {
        this.fileRepository = fileRepository;
        this.linearSearch = linearSearch;
        this.inputService = inputService;
        this.bikeBuilderService = bikeBuilderService;
    }

    public void search() {
        Class bikeType = inputService.findBikeType();
        linearSearch.linearSearch(bikeBuilderService.builder(bikeType), fileRepository.getBikes());
    }
}