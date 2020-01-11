package com.ecobike.app.repository.impl;

import com.ecobike.app.mapper.EBikeMapper;
import com.ecobike.app.mapper.FoldingBikeMapper;
import com.ecobike.app.mapper.SpeedelecMapper;
import com.ecobike.app.model.AbstractBike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FileRepositoryTest {

    private final static String DATA_FILE = "src\\test\\java\\com\\ecobike\\app\\repository\\impl\\data\\success-test.txt";
    private SpeedelecMapper speedelecMapper = new SpeedelecMapper();;
    private EBikeMapper eBikeMapper = new EBikeMapper();
    private FoldingBikeMapper foldingBikeMapper = new FoldingBikeMapper();
    @Autowired
    private FileRepository fileRepository;
    private ArgumentCaptor<List<AbstractBike>> listArgumentCaptor = ArgumentCaptor.forClass(List.class);

    @Test
    public void readFile() throws IOException {
        fileRepository.readFile(DATA_FILE);
        List<AbstractBike> list = listArgumentCaptor.getValue();
        assertTrue(list.size() > 0);
        assertEquals(3, list.size());
    }

    @Test
    public void writeToFile() {

    }

    @Test
    public void add() {

    }
}