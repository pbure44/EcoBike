package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BikeBuilderServiceTest {

    @Mock
    private BufferedReader reader;
    @Mock
    private InputService inputService = new InputService();

    private BikeBuilderService bikeBuilderService=new BikeBuilderService();

    private EBike testEBike = new EBike("E-BIKE", "Lankeleisi",
            65, 24200, false, 10000, "black", new BigDecimal(2399));
    private SpeedElec testSpeedElec = new SpeedElec("SPEEDELEC", "Booster",
            35, 10900, false, 13200, "green", new BigDecimal(1279));
    private FoldingBike testFoldingBike = new FoldingBike("FOLDING BIKE", "Benetti",
            24, 6, 9400, true, "silver", new BigDecimal(1195));

    @Test
    public void builderEBikeClassSuccess(Class bikeClass) throws IOException {
    bikeBuilderService.builder(EBike.class);

        when(reader.readLine()).thenReturn("Lankeleisi");
        String brand = inputService.inputBrand();
        when(reader.readLine()).thenReturn(String.valueOf(65));
        int maxSpeed = inputService.inputMaxSpeed();
        when(reader.readLine()).thenReturn(String.valueOf(24200));
        int batteryCapacity = inputService.inputBatteryCapacity();
        when(reader.readLine()).thenReturn(String.valueOf(false));
        boolean lights = inputService.inputLights();
        when(reader.readLine()).thenReturn(String.valueOf(10000));
        int weight = inputService.inputWeight();
        when(reader.readLine()).thenReturn("black");
        String colour = inputService.inputColour();
        when(reader.readLine()).thenReturn(String.valueOf(2399));
        BigDecimal price = inputService.inputPrice();
    }
}