package com.ecobike.app.service;

public interface ICatalogService {
    void showAll();
    Object findOne();
    void readFile(String fileName);
    void writeToFile(String fileName);
    void add(Class bikeClass);
}
