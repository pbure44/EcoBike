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

    public String dataFilePath;

    public CatalogService() {
        this.fileRepository = new FileRepository();
        this.inputService = new InputService();
    }

    @Override
    public void showAll() {
        fileRepository.showAll();
    }


    @Override
    public Object findOne() {
        List<String> list = sortService.sort(bikesList);
        try {
            String bike = repo.findOne(list);
            Collections.binarySearch()
        } catch () {
            System.out.println("Bike is not found");
        }

        return bike;
    }

    @Override
    public void add(Class bikeClass) {
        AbstractBike abstractBike = bikeBuilderService.build(bikeClass);
        fileRepository.add(abstractBike);
    }


    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(MenuService.dataFile, false);
            for (AbstractBike list : bikesList) {
                fileWriter.write(list.toList() + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addNewEBike(EBike bike) {
        inputService.inputBrand(bike);
        inputService.inputM(bike);
        inputService.inputNumOfGears(bike);
        inputService.inputWeight(bike);
        inputService.inputLights(bike);
        inputService.inputColour(bike);
        fileRepository.add(bike);
    }

    @Override
    public void addNewSpeedElec() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            SpeedElec speedElec = new SpeedElec();
            System.out.println();
            System.out.println("Please enter the Brand name");
            speedElec.setBrand("FOLDING BIKE " + reader.readLine());
            System.out.println("Please enter the maximum speed (in km/h)");
            speedElec.setMaxSpeed(Integer.parseInt(reader.readLine()));
            System.out.println("Please enter the weight of the bike (in grams)");
            speedElec.setWeight(Integer.parseInt(reader.readLine()));
            System.out.println("Please enter the availability of lights at front and back (TRUE/FALSE)");
            speedElec.setLights(Boolean.parseBoolean(reader.readLine()));
            System.out.println("Please enter the color");
            speedElec.setColour(reader.readLine());
            System.out.println("Please enter the price (EUR)");
            speedElec.setPrice(new BigDecimal(Integer.valueOf(reader.readLine())));
            System.out.println(speedElec);
            bikesList.add(speedElec);
            System.out.println("New bike added");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
