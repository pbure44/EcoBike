package com.ecobike.app.service.impl;

import com.ecobike.app.TestApplicationConfiguration;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestApplicationConfiguration.class)
class BikeBuilderServiceTest {

    @Mock
    private InputService inputService;

    @InjectMocks
    private BikeBuilderService bikeBuilderService;

    private EBike testEBike = new EBike("E-BIKE", "Lankeleisi",
            65, 24200, false, 10000, "black", new BigDecimal(2399));
    private SpeedElec testSpeedElec = new SpeedElec("SPEEDELEC", "Booster",
            35, 10900, false, 13200, "green", new BigDecimal(1279));
    private FoldingBike testFoldingBike = new FoldingBike("FOLDING BIKE", "Benetti",
            24, 6, 9400, true, "silver", new BigDecimal(1195));

    @Test
    public void testBuilderEBikeClassSuccess() {

        when(inputService.inputBrand()).thenReturn("Lankeleisi");
        when(inputService.inputMaxSpeed()).thenReturn(65);
        when(inputService.inputBatteryCapacity()).thenReturn(24200);
        when(inputService.inputLights()).thenReturn(false);
        when(inputService.inputWeight()).thenReturn(10000);
        when(inputService.inputColour()).thenReturn("black");
        when(inputService.inputPrice()).thenReturn(BigDecimal.valueOf(2399));

        EBike bike = (EBike) bikeBuilderService.builder(EBike.class);

        assertEquals(testEBike.getType(), bike.getType());
        assertEquals(testEBike.getBrand(), bike.getBrand());
        assertEquals(testEBike.getMaxSpeed(), bike.getMaxSpeed());
        assertEquals(testEBike.getBatteryCapacity(), bike.getBatteryCapacity());
        assertEquals(testEBike.getLights(), bike.getLights());
        assertEquals(testEBike.getWeight(), bike.getWeight());
        assertEquals(testEBike.getColour(), bike.getColour());
        assertEquals(testEBike.getPrice(), bike.getPrice());

    }

    @Test
    public void testBuilderSpeedElecClassSuccess() {

        when(inputService.inputBrand()).thenReturn("Booster");
        when(inputService.inputMaxSpeed()).thenReturn(35);
        when(inputService.inputBatteryCapacity()).thenReturn(10900);
        when(inputService.inputLights()).thenReturn(false);
        when(inputService.inputWeight()).thenReturn(9400);
        when(inputService.inputColour()).thenReturn("green");
        when(inputService.inputPrice()).thenReturn(BigDecimal.valueOf(1279));

        SpeedElec bike = (SpeedElec) bikeBuilderService.builder(SpeedElec.class);

        assertEquals(testSpeedElec.getType(), bike.getType());
        assertEquals(testSpeedElec.getBrand(), bike.getBrand());
        assertEquals(testSpeedElec.getMaxSpeed(), bike.getMaxSpeed());
        assertEquals(testSpeedElec.getBatteryCapacity(), bike.getBatteryCapacity());
        assertEquals(testSpeedElec.getLights(), bike.getLights());
        assertEquals(testSpeedElec.getColour(), bike.getColour());
        assertEquals(testSpeedElec.getPrice(), bike.getPrice());

    }

    @Test
    public void testBuilderFoldingBikeClassSuccess() {

        when(inputService.inputBrand()).thenReturn("Benetti");
        when(inputService.inputWheelSize()).thenReturn(24);
        when(inputService.inputNumOfGears()).thenReturn(6);
        when(inputService.inputLights()).thenReturn(true);
        when(inputService.inputWeight()).thenReturn(9400);
        when(inputService.inputColour()).thenReturn("silver");
        when(inputService.inputPrice()).thenReturn(BigDecimal.valueOf(1195));

        FoldingBike bike = (FoldingBike) bikeBuilderService.builder(FoldingBike.class);

        assertEquals(testFoldingBike.getType(), bike.getType());
        assertEquals(testFoldingBike.getBrand(), bike.getBrand());
        assertEquals(testFoldingBike.getWheelSize(), bike.getWheelSize());
        assertEquals(testFoldingBike.getNumOfGears(), bike.getNumOfGears());
        assertEquals(testFoldingBike.getLights(), bike.getLights());
        assertEquals(testFoldingBike.getWeight(), bike.getWeight());
        assertEquals(testFoldingBike.getColour(), bike.getColour());
        assertEquals(testFoldingBike.getPrice(), bike.getPrice());

    }

    @Test
    public void testBuilderExpectedException() {
        Assertions.assertThrows(Exception.class, () -> {
            bikeBuilderService.builder(null);
        });
    }

}