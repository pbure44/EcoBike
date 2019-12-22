package com.ecobike.app.repository.impl;

import com.ecobike.app.mapper.EBikeMapper;
import com.ecobike.app.mapper.FoldingBikeMapper;
import com.ecobike.app.mapper.SpeedelecMapper;
import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.enumerator.BikeType;
import com.ecobike.app.repository.ICatalogRepository;
import com.ecobike.app.service.impl.MenuService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileRepository implements ICatalogRepository {

    private List<AbstractBike> bikes;
    private List<AbstractBike> newBikes;
    private SpeedelecMapper speedelecMapper;
    private EBikeMapper eBikeMapper;
    private FoldingBikeMapper foldingBikeMapper;

    public FileRepository() {
        this.bikes = new ArrayList<>();
        this.newBikes = new ArrayList<>();
        this.speedelecMapper = new SpeedelecMapper();
        this.eBikeMapper = new EBikeMapper();
        this.foldingBikeMapper = new FoldingBikeMapper();
    }



    @Override
    public void readFile(String dataFile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        dataFile = reader.readLine();

        BufferedReader in = new BufferedReader(new FileReader(dataFile));
        try {
            String str;
            String[] tokens;
            while ((str = in.readLine()) != null) {
                tokens = str.split(";");
                if (tokens[0].contains(BikeType.SPEEDELEC.getBikeType())) {
                    bikes.add(speedelecMapper.toSpeedElec(tokens));
                } else if (tokens[0].contains(BikeType.FOLDING_BIKE.getBikeType())) {
                    bikes.add(foldingBikeMapper.toFoldingBike(tokens));
                } else if (tokens[0].contains(BikeType.E_BIKE.getBikeType())) {
                    bikes.add(eBikeMapper.toEBike(tokens));
                } else {
                    throw new IllegalArgumentException("Error in If-Else construction");
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    @Override
    public void showAll() {
        for (AbstractBike bike : bikes) {
            System.out.println(bike);
        }
    }

    @Override
    public void writeToFile() throws IOException {

        FileWriter fileWriter = new FileWriter(MenuService.dataFile, false);
        for (AbstractBike list : bikes) {
            fileWriter.write(list.toList() + System.getProperty("line.separator"));
        }
    }

    public void add(AbstractBike bike){
        newBikes.add(bike);
    }

}
