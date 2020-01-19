package com.ecobike.app.service.impl;

import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.service.ICatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Service
public class MenuService {
    private final ICatalogService catalogService;
    private BufferedReader reader;

    public MenuService(CatalogService catalogService) {
        this.catalogService = catalogService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void menuStart() {
        try {
            System.out.println("Please enter the route to datafile");
            String fileName = reader.readLine();
            catalogService.readFile(fileName);
            System.out.println("DataFile loaded successfully");
            menuList(fileName);
        } catch (Exception e) {
            log.warn("Menu start: failed to execute program");
            System.err.println("Failed to execute program, try again");
        }
    }

    private void menuList(String fileName) {
        try {
            while (true) {
                System.out.println("* * * * * * *");
                System.out.println("Please make your choice:\n" +
                        "1 - Show the entire EcoBike catalog\n" +
                        "2 – Add a new folding bike\n" +
                        "3 – Add a new speedelec\n" +
                        "4 – Add a new e-bike\n" +
                        "5 – Find bike\n" +
                        "6 – Write to file\n" +
                        "7 – Stop the program");
                int num = Integer.parseInt(reader.readLine());
                switch (num) {
                    case 1:
                        catalogService.showAll();
                        continue;
                    case 2:
                        catalogService.add(FoldingBike.class);
                        continue;
                    case 3:
                        catalogService.add(SpeedElec.class);
                        continue;
                    case 4:
                        catalogService.add(EBike.class);
                        continue;
                    case 5:
                        catalogService.findOne();
                        continue;
                    case 6:
                        catalogService.writeToFile(fileName);
                        continue;
                    case 7:
                        break;
                    default:
                        System.err.println("Incorrect input, please enter number from 1 to 7");
                        continue;
                }
                break;
            }
        } catch (IOException e) {
            System.err.println("Some error in menu list");
        }
    }
}
