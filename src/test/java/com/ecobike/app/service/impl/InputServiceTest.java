package com.ecobike.app.service.impl;

import com.ecobike.app.model.SpeedElec;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputServiceTest {

    @Mock
    private BufferedReader reader;

    private InputService inputService = new InputService();

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

//    @Bean
//    @Primary
//    public MenuService menuService(){
//        return mock(MenuService.class);
//    }
}