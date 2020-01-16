package com.ecobike.app.repository;

import com.ecobike.app.model.AbstractBike;

import java.io.IOException;
import java.util.List;

public interface IFileRepository {
    List<AbstractBike> getBikes();

    void readFile(String fileName) throws IOException;

    void showAll();

    void writeToFile(String fileName) throws IOException;

    void add(AbstractBike bike);
}
