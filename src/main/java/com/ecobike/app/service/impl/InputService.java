package com.ecobike.app.service.impl;

import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Service
public class InputService {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String inputBrand() {
        System.out.println("\nPlease enter the Brand name");
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.err.println("Invalid brand");
            }
        }
    }

    public Integer inputWheelSize() {
        System.out.println("\nPlease enter the size of the wheels (in inch)");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public Integer inputNumOfGears() {
        System.out.println("\nPlease enter the number of Gears ");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public Integer inputWeight() {
        System.out.println("\nPlease enter the weight of the bike (in grams)");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public boolean inputLights() {
        System.out.println("\nPlease enter the availability of lights at front and back (TRUE/FALSE)");
        while (true) {
            try {
                return Boolean.parseBoolean(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public String inputColour() {
        System.out.println("\nPlease enter the colour");
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public BigDecimal inputPrice() {
        System.out.println("\nPlease enter the price (EUR)");
        while (true) {
            try {
                return new BigDecimal(Integer.valueOf(reader.readLine()));
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public Integer inputMaxSpeed() {
        System.out.println("\nPlease enter the maximum speed (in km/h)");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }

    public Integer inputBatteryCapacity() {
        System.out.println("\nPlease enter the battery capacity (in mAh)");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }

    }

    public Class findBikeType() {
        System.out.println("Please enter the number of type of bike:\n" +
                "1 - E-Bike\n" +
                "2 - Folding Bike\n" +
                "3 - SpeedElec\n");
        while (true) {
            try {
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                        return EBike.class;
                    case 2:
                        return FoldingBike.class;
                    case 3:
                        return SpeedElec.class;
                    default:
                        System.out.println("Incorrect input. Please enter a number: 1 or 2 or 3");
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Enter correct data");
            }
        }
    }
}
