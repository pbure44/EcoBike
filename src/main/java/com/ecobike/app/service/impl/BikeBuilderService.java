package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;

public class BikeBuilderService {

    private InputService inputService;

    public BikeBuilderService() {
        this.inputService = inputService;
    }

    public AbstractBike bikeBuilder(Class bikeClass) {
        if (bikeClass.equals(EBike.class)) {
            EBike bike = new EBike();
            inputService.inputBrand(bike);
            inputService.inputMaxSpeed(bike);
            inputService.inputNumOfGears(bike);
            inputService.inputWeight(bike);
            inputService.inputLights(bike);
            inputService.inputColour(bike);
        }
    }
}
