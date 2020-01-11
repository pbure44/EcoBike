package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.model.enumerator.BikeType;
import org.springframework.stereotype.Service;

@Service
public class BikeBuilderService {

    private InputService inputService;

    public BikeBuilderService() {
        this.inputService = new InputService();
    }

    public AbstractBike builder(Class bikeClass) {
        try {
            if (bikeClass.equals(EBike.class)) {
                return createEBike();
            } else if (bikeClass.equals(SpeedElec.class)) {
                return createSpeedElec();
            } else if (bikeClass.equals(FoldingBike.class)) {
                return createFoldingBike();
            } else {
                throw new IllegalArgumentException("Error in if-else bikeBuilder method");
            }
        } catch (Exception e) {
            System.out.println("Error in bikeBuilder method");
        }
        return null;
    }

    private EBike createEBike() {
        return EBike.builder()
                .type(BikeType.E_BIKE.getBikeType())
                .brand(inputService.inputBrand())
                .maxSpeed(inputService.inputMaxSpeed())
                .weight(inputService.inputWeight())
                .lights(inputService.inputLights())
                .batteryCapacity(inputService.inputBatteryCapacity())
                .colour(inputService.inputColour())
                .price(inputService.inputPrice())
                .build();
    }

    private SpeedElec createSpeedElec() {
        return SpeedElec.builder()
                .type(BikeType.SPEEDELEC.getBikeType())
                .brand(inputService.inputBrand())
                .maxSpeed(inputService.inputMaxSpeed())
                .weight(inputService.inputWeight())
                .lights(inputService.inputLights())
                .batteryCapacity(inputService.inputBatteryCapacity())
                .colour(inputService.inputColour())
                .price(inputService.inputPrice())
                .build();
    }

    private FoldingBike createFoldingBike() {
        return FoldingBike.builder()
                .type(BikeType.FOLDING_BIKE.getBikeType())
                .brand(inputService.inputBrand())
                .wheelSize(inputService.inputWheelSize())
                .numOfGears(inputService.inputNumOfGears())
                .weight(inputService.inputWeight())
                .lights(inputService.inputLights())
                .colour(inputService.inputColour())
                .price(inputService.inputPrice())
                .build();
    }
}
