package com.ecobike.app.service.impl;

import com.ecobike.app.TestApplicationConfiguration;
import com.ecobike.app.model.EBike;
import com.ecobike.app.repository.impl.FileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestApplicationConfiguration.class)
class CatalogServiceTest {

    @Mock
    private BikeBuilderService bikeBuilderService;

    @Mock
    private SearchService searchService;

    @Mock
    private FileRepository fileRepository;

    @InjectMocks
    private CatalogService catalogService;

    private EBike testBike = new EBike("E-BIKE", "Lankeleisi",
            65, 24200, false, 10000, "black", new BigDecimal(2399));

    @Test
    void testFindOneSuccess() {
        catalogService.findOne();
        verify(searchService).search();
    }

    @Test
    void testAddSucess() {
        when(bikeBuilderService.builder(any())).thenReturn(testBike);
        catalogService.add(EBike.class);
        verify(fileRepository).add(testBike);
    }

    @Test
    void testAddZeroInteractions() {
        when(bikeBuilderService.builder(any())).thenReturn(null);
        catalogService.add(EBike.class);
        verifyZeroInteractions(fileRepository);
    }


    @Test
    void testWriteToFileSuccess() throws IOException {
        catalogService.writeToFile("test.txt");
        verify(fileRepository).writeToFile("test.txt");
    }

    @Test
    void testWriteToFileHandleException() throws IOException {
        doThrow(IOException.class).when(fileRepository).writeToFile("test.txt");
        assertDoesNotThrow(() -> catalogService.writeToFile("test.txt"));
    }

    @Test
    void testReadFileSuccess() throws IOException {
        catalogService.readFile("test.txt");
        verify(fileRepository).readFile("test.txt");
    }

    @Test
    void testReadFileHandleException() throws IOException {
        doThrow(IOException.class).when(fileRepository).readFile("test.txt");
        assertDoesNotThrow(() -> catalogService.readFile("test.txt"));
    }
}