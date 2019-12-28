package com.ecobike.app.repository.impl;

import com.ecobike.app.mapper.EBikeMapper;
import com.ecobike.app.mapper.FoldingBikeMapper;
import com.ecobike.app.mapper.SpeedelecMapper;
import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.enumerator.BikeType;
import com.ecobike.app.repository.IFileRepository;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FileRepository implements IFileRepository {

    private static final List<AbstractBike> BIKES = Collections.synchronizedList(new ArrayList<>());
    private static final List<AbstractBike> NEW_BIKES = Collections.synchronizedList(new ArrayList<>());
    private SpeedelecMapper speedelecMapper;
    private EBikeMapper eBikeMapper;
    private FoldingBikeMapper foldingBikeMapper;

    public FileRepository() {
        this.speedelecMapper = new SpeedelecMapper();
        this.eBikeMapper = new EBikeMapper();
        this.foldingBikeMapper = new FoldingBikeMapper();
    }

    @Override
    public void readFile(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String str;
        while ((str = in.readLine()) != null) {
            String[] tokens = str.split(";");
            if (tokens[0].contains(BikeType.SPEEDELEC.getBikeType())) {
                addInGeneralList(speedelecMapper.toSpeedElec(tokens));
            } else if (tokens[0].contains(BikeType.FOLDING_BIKE.getBikeType())) {
                addInGeneralList(foldingBikeMapper.toFoldingBike(tokens));
            } else if (tokens[0].contains(BikeType.E_BIKE.getBikeType())) {
                addInGeneralList(eBikeMapper.toEBike(tokens));
            } else {
                throw new IllegalArgumentException("Error in If-Else readFile method");
            }
        }
    }

    @Override
    public void showAll() {
        for (Object bike : BIKES) {
            System.out.println(bike);
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        synchronized (BIKES) {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BIKES.addAll(NEW_BIKES);
            for (AbstractBike list : BIKES) {
                fileWriter.write(list.toList() + System.getProperty("line.separator"));
            }
        }
    }

    public void add(@Valid AbstractBike bike) {
        NEW_BIKES.add(bike);
    }

    private void addInGeneralList(@Valid AbstractBike bike) {
        BIKES.add(bike);
    }
}
