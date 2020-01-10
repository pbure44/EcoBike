package com.ecobike.app.mapper;

import com.ecobike.app.model.SpeedElec;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SpeedelecMapperTest {
   private SpeedelecMapper speedelecMapper = new SpeedelecMapper();

    @Test
    public void testToSpeedElec() {
        String[] tokens = {"brand", "50", "15000", "true", "10000", "white", "2000"};
        SpeedElec bikeTest = speedelecMapper.toSpeedElec(tokens);
        SpeedElec speedElec = new SpeedElec();
        speedElec.setBrand("brand");
        speedElec.setBatteryCapacity(10000);
        speedElec.setMaxSpeed(50);
        speedElec.setWeight(15000);
        speedElec.setLights(true);
        speedElec.setColour("white");
        speedElec.setPrice(BigDecimal.valueOf(2000));
        assertEquals("message", bikeTest, speedElec);
    }
}