package com.ecobike.app.mapper;

import com.ecobike.app.model.EBike;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest

public class EBikeMapperTest {

    private EBikeMapper eBikeMapper = new EBikeMapper();

    @Test
    public void testToEBikeSuccess() {
        String[] tokens = {"brand", "50", "15000", "true", "10000", "white", "2000"};
        EBike bikeTest = eBikeMapper.toEBike(tokens);
        EBike eBike = new EBike();
        eBike.setBrand("brand");
        eBike.setBatteryCapacity(10000);
        eBike.setMaxSpeed(50);
        eBike.setWeight(15000);
        eBike.setLights(true);
        eBike.setColour("white");
        eBike.setPrice(BigDecimal.valueOf(2000));
        assertEquals("message",bikeTest,eBike);
    }
}