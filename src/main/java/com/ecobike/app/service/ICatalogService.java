package com.ecobike.app.service;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;

import java.util.LinkedList;
import java.util.Map;

public interface ICatalogService {
    void showAll();
    Object findOne();

    void add(Class<AbstractBike> bikeClass);
}
