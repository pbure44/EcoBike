package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class SortService {
    private final InputService inputService;
    private final BikeBuilderService bikeBuilderService;

    public SortService(InputService inputService, BikeBuilderService bikeBuilderService) {
        this.inputService = inputService;
        this.bikeBuilderService = bikeBuilderService;
    }



    public void find() {
        findBikeBuilder(inputService.findBikeType());

    }

    private void findBikeBuilder(Integer num) {
        switch (num){
            case 1:
                search(inputService.inputBrandFind(),1);
            case 2:
                search(inputService.inputWheelSize(),2);
            case 3:
                search(inputService.inputNumOfGears(),3);
            case 4:
                search(inputService.inputMaxSpeed(),4);
            case 5:
                search(inputService.inputBatteryCapacity(),5);
            case 6:
                search(inputService.inputWeight(),6);
            case 7:
                search(inputService.inputLights(),7);
            case 8:
                search(inputService.inputColour(),8);
            case 9:
                search(inputService.inputPrice(),9);
        }

    }

    private AbstractBike search(Object field, int num){
        return null;
    }
}
