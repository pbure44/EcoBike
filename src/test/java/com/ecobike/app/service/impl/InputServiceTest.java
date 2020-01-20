package com.ecobike.app.service.impl;

import com.ecobike.app.TestApplicationConfiguration;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestApplicationConfiguration.class)
class InputServiceTest {


    @Mock
    private BufferedReader reader;
    @InjectMocks
    private InputService inputService;

    @Test
    void testInputBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand();
        assertNotNull(brand);
        assertEquals("Booster", brand);
    }

    @Test
    void testInputWheelSizeSuccess() throws IOException {
        when(reader.readLine()).thenReturn("24");
        int wheelSize = inputService.inputWheelSize();
        assertNotNull(wheelSize);
        assertEquals(24, wheelSize);
    }

    @Test
    void testInputNumOfGearsSuccess() throws IOException {
        when(reader.readLine()).thenReturn("4");
        int numOfGears = inputService.inputNumOfGears();
        assertNotNull(numOfGears);
        assertEquals(4, numOfGears);
    }

    @Test
    void testInputWeightSuccess() throws IOException {
        when(reader.readLine()).thenReturn("20000");
        int weight = inputService.inputWeight();
        assertNotNull(weight);
        assertEquals(20000, weight);
    }

    @Test
    void testInputLightsSuccess() throws IOException {
        when(reader.readLine()).thenReturn("true");
        boolean lights = inputService.inputLights();
        assertNotNull(lights);
        assertEquals(true, lights);
    }

    @Test
    void inputColourSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Red");
        String colour = inputService.inputBrand();
        assertNotNull(colour);
        assertEquals("Red", colour);
    }

    @Test
    void testInputPriceSuccess() throws IOException {
        when(reader.readLine()).thenReturn("1000");
        BigDecimal price = inputService.inputPrice();
        assertNotNull(price);
        assertEquals(new BigDecimal(1000), price);
    }

    @Test
    void testInputMaxSpeedSuccess() throws IOException {
        when(reader.readLine()).thenReturn("60");
        int maxSpeed = inputService.inputMaxSpeed();
        assertNotNull(maxSpeed);
        assertEquals(60, maxSpeed);
    }

    @Test
    void testInputBatteryCapacitySuccess() throws IOException {
        when(reader.readLine()).thenReturn("30000");
        int batteryCapacity = inputService.inputBatteryCapacity();
        assertNotNull(batteryCapacity);
        assertEquals(30000, batteryCapacity);
    }

    @Test
    void testFindEBikeSuccess() throws IOException {
        when(reader.readLine()).thenReturn("1");
        Class bikeType = inputService.findBikeType();
        assertNotNull(bikeType);
        assertEquals(EBike.class, bikeType);
    }

    @Test
    void testFindFoldingBikeSuccess() throws IOException {
        when(reader.readLine()).thenReturn("2");
        Class bikeType = inputService.findBikeType();
        assertNotNull(bikeType);
        assertEquals(FoldingBike.class, bikeType);
    }

    @Test
    void testFindSpeedElecSuccess() throws IOException {
        when(reader.readLine()).thenReturn("3");
        Class bikeType = inputService.findBikeType();
        assertNotNull(bikeType);
        assertEquals(SpeedElec.class, bikeType);
    }
}