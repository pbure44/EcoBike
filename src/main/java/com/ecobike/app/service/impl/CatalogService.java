package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.repository.IFileRepository;
import com.ecobike.app.repository.impl.FileRepository;
import com.ecobike.app.service.ICatalogService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CatalogService implements ICatalogService {
    private final IFileRepository fileRepository;
    private final BikeBuilderService bikeBuilderService;
    private SearchService searchService;

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

        searchService.find();
    }

    @Override
    public void add(Class bikeClass) {
        AbstractBike abstractBike = bikeBuilderService.builder(bikeClass);
        fileRepository.add(abstractBike);
    }

    @Override
    public void writeToFile(String fileName) {
        try {
            fileRepository.writeToFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String fileName) {
        try {
            fileRepository.readFile(fileName);
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }
}
