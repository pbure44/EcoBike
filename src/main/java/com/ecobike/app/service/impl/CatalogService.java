package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.repository.IFileRepository;
import com.ecobike.app.repository.impl.FileRepository;
import com.ecobike.app.service.ICatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CatalogService implements ICatalogService {
    private final IFileRepository fileRepository;
    private final BikeBuilderService bikeBuilderService;
    private final SearchService searchService;

    public CatalogService(FileRepository fileRepository, BikeBuilderService bikeBuilderService, SearchService searchService) {
        this.fileRepository = fileRepository;
        this.bikeBuilderService = bikeBuilderService;
        this.searchService = searchService;
    }

    @Override
    public void showAll() {
        fileRepository.showAll();
    }

    @Override
    public void findOne() {
        searchService.search();
    }

    @Override
    public void add(Class bikeClass) {
        AbstractBike abstractBike = bikeBuilderService.builder(bikeClass);
        if (abstractBike != null) {
            fileRepository.add(abstractBike);
        } else {
            log.warn("Adding bike: failed to get bike from builder={}", bikeClass.getName());
            System.err.println("Bike was not added");
        }
    }

    @Override

    public void writeToFile(String fileName) {
        try {
            fileRepository.writeToFile(fileName);
        } catch (IOException e) {
            log.warn("Write to file: failed to write bikes to file={}", fileName);
            System.err.println("Wrote to file failed");
        }
    }

    @Override
    public void readFile(String fileName) {
        try {
            fileRepository.readFile(fileName);
        } catch (IOException e) {
            System.err.println("File reading failed");
        }
    }
}
