package com.ecobike.app.service.impl;

import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.repository.impl.FileRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuService {
    private CatalogService catalogService = new CatalogService();
    private FileRepository fileRepository = new FileRepository();

    public static String dataFile;

    public void menuStart() throws IOException {
        try {
            System.out.println("Please enter the route to datafile");
            fileRepository.readFile(dataFile);
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
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Integer num = Integer.parseInt(reader.readLine());
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
                        catalogService.writeToFile();
                        continue;
                    case 7:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                if (num == 7) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect input, please enter number from 1 to 7");
            menuList();
        }
    }
}
