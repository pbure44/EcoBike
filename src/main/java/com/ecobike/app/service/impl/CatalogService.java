package com.ecobike.app.service.impl;

import com.ecobike.app.mapper.SpeedelecMapper;
import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.model.enumerator.BikeType;
import com.ecobike.app.repository.impl.FileRepository;
import com.ecobike.app.service.ICatalogService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CatalogService implements ICatalogService {
    private FileRepository fileRepository;
    private InputService inputService;
    private BikeBuilderService bikeBuilderService;

    public String dataFilePath;

    public CatalogService() {
        this.fileRepository = new FileRepository();
        this.inputService = new InputService();
        this.bikeBuilderService = new BikeBuilderService();
    }

    @Override
    public void showAll() {
        fileRepository.showAll();
    }


    @Override
    public Object findOne() {
//        List<String> list = sortService.sort(bikesList);
//        try {
//            String bike = repo.findOne(list);
//            Collections.binarySearch()
//        } catch () {
//            System.out.println("Bike is not found");
//        }
//
        return -1;
    }

    @Override
    public void add(Class bikeClass) {
        AbstractBike abstractBike = bikeBuilderService.builder(bikeClass);
        fileRepository.add(abstractBike);
    }

    public void writeToFile() {
        try {
            fileRepository.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws IOException{
        try {
            fileRepository.readFile();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }
}
