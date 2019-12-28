package com.ecobike.app.service.impl;

import com.ecobike.app.model.SpeedElec;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class InputServiceTest {

    @Mock
    private BufferedReader reader;

    @Autowired
    private InputService inputService;

    @Test
    void inputSpeedelecBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand(SpeedElec.class);
        assertNotNull(brand);
        assertEquals("SPEEDELEC Booster", brand);
    }

    @Test
    void inputEBikeBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand(SpeedElec.class);
        assertNotNull(brand);
        assertEquals("E-BIKE Booster", brand);
    }

    @Test
    void inputFoldingBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand(SpeedElec.class);
        assertNotNull(brand);
        assertEquals("FOLDING BIKE Booster", brand);
    }
}