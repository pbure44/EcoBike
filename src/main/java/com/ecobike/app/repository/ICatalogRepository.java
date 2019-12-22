package com.ecobike.app.repository;

import java.io.IOException;

public interface ICatalogRepository {
    void readFile() throws IOException;
    void showAll();
    void writeToFile() throws IOException;
}
