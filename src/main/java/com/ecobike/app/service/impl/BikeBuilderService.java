package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;

public class BikeBuilderService {

    private InputService inputService;

    public BikeBuilderService() {
        this.inputService = inputService;
    }

    public AbstractBike builder(Class bikeClass) {
        try {
            if (bikeClass.equals(EBike.class)) {
                EBike bike = new EBike();
                bike.setBrand(inputService.inputBrand(EBike.class));
                bike.setMaxSpeed(inputService.inputMaxSpeed());
                bike.setWeight(inputService.inputWeight());
                bike.setLights(inputService.inputLights());
                bike.setColour(inputService.inputColour());
                bike.setPrice(inputService.inputPrice());
                return bike;
            } else if (bikeClass.equals(SpeedElec.class)) {
                SpeedElec bike = new SpeedElec();
                bike.setBrand(inputService.inputBrand(SpeedElec.class));
                bike.setMaxSpeed(inputService.inputMaxSpeed());
                bike.setWeight(inputService.inputWeight());
                bike.setLights(inputService.inputLights());
                bike.setColour(inputService.inputColour());
                bike.setPrice(inputService.inputPrice());
                return bike;
            } else if (bikeClass.equals(FoldingBike.class)) {
                FoldingBike bike = new FoldingBike();
                bike.setBrand(inputService.inputBrand(FoldingBike.class));
                bike.setWheelSize(inputService.inputWheelSize());
                bike.setNumOfGears(inputService.inputNumOfGears());
                bike.setWeight(inputService.inputWeight());
                bike.setLights(inputService.inputLights());
                bike.setColour(inputService.inputColour());
                bike.setPrice(inputService.inputPrice());
                return bike;
            } else {
                throw new IllegalArgumentException("Error in if-else bikeBuilder method");
            }
        }catch (Exception e){
            System.out.println("Error in bikeBuilder method");
        }
    return null;
    }

}
