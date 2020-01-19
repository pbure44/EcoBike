package com.ecobike.app.service.impl;

import com.ecobike.app.TestApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestApplicationConfiguration.class)
class InputServiceTest {

    @Mock
    private BufferedReader reader;

    private InputService inputService = new InputService();

    @Test
    void testInputSpeedelecBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand();
        assertNotNull(brand);
        assertEquals("SPEEDELEC Booster", brand);
    }

    @Test
    void testInputEBikeBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand();
        assertNotNull(brand);
        assertEquals("E-BIKE Booster", brand);
    }

    @Test
    void testInputFoldingBrandSuccess() throws IOException {
        when(reader.readLine()).thenReturn("Booster");
        String brand = inputService.inputBrand();
        assertNotNull(brand);
        assertEquals("FOLDING BIKE Booster", brand);
    }

}