package com.ecobike.app.service.impl;

import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.repository.IFileRepository;
import com.ecobike.app.repository.impl.FileRepository;
import com.ecobike.app.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class MenuService {
    private final ICatalogService catalogService;
    private BufferedReader reader;
    private static String fileName;

    public MenuService(CatalogService catalogService) {
        this.catalogService = catalogService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void menuStart() throws IOException {
        try {
            fileName = reader.readLine();
            System.out.println("Please enter the route to datafile");
            catalogService.readFile(fileName);
            System.out.println("DataFile loaded successfully");
            menuList();
        } catch (IOException e) {
            System.out.println("DataFile not found, please check filename and path");
            menuStart();
        }
    }

    private void menuList() {
        try {
            while (true) {
                System.out.println("* * * * * * *");
                System.out.println("Please make your choice:\n" +
                        "1 - Show the entire EcoBike catalog\n" +
                        "2 – Add a new folding bike\n" +
                        "3 – Add a new speedelec\n" +
                        "4 – Add a new e-bike\n" +
                        "5 – Find the first item of a particular brand\n" +
                        "6 – Write to file\n" +
                        "7 – Stop the program");
                Integer num = Integer.parseInt(reader.readLine());
                switch (num) {
                    case 1:
                        catalogService.showAll(); // правильно ли дергать из repository??
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
                        throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect input, please enter number from 1 to 7");
            menuList();
        }
    }
}
