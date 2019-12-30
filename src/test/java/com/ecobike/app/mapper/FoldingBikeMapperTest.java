package com.ecobike.app.mapper;

import com.ecobike.app.model.FoldingBike;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
public class FoldingBikeMapperTest {
    private FoldingBikeMapper foldingBikeMapper = new FoldingBikeMapper();

    @Test
    public void testToFoldingBike() {
        String[] tokens = {"brand", "26", "2", "15000", "true", "white", "2000"};
        FoldingBike bikeTest = foldingBikeMapper.toFoldingBike(tokens);
        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand("brand");
        foldingBike.setWheelSize(26);
        foldingBike.setNumOfGears(2);
        foldingBike.setWeight(15000);
        foldingBike.setLights(true);
        foldingBike.setColour("white");
        foldingBike.setPrice(BigDecimal.valueOf(2000));
        assertEquals("message", bikeTest, foldingBike);
    }
}