package com.ecobike.app.repository;

import com.ecobike.app.model.AbstractBike;

import javax.validation.Valid;
import java.io.IOException;

public interface IFileRepository {
    void readFile(String fileName) throws IOException;
    void showAll();
    void writeToFile(String fileName) throws IOException;
    void add(AbstractBike bike);
}
