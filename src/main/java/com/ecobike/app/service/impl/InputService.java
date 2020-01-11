package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;
import com.ecobike.app.model.enumerator.BikeType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Service
public class InputService {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String inputBrand() {
        System.out.println();
        System.out.println("Please enter the Brand name");
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("Error in input Brand method");
            }
        }
    }

    public Integer inputWheelSize() {
        System.out.println();
        System.out.println("Please enter the size of the wheels (in inch)");
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputWheelSize method");
                System.out.println("Enter correct data");
            }
        }
    }

    public Integer inputNumOfGears() {
        System.out.println();
        System.out.println("Please enter the number of Gears ");
        while (true) {
            try {
                Integer num = Integer.parseInt(reader.readLine());
                return num;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputNumOfGears method");
                System.out.println("Enter correct data");
            }
        }
    }

    public Integer inputWeight() {
        System.out.println();
        System.out.println("Please enter the weight of the bike (in grams)");
        while (true) {
            try {
                Integer wght = Integer.parseInt(reader.readLine());
                return wght;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputWeight method");
                System.out.println("Enter correct data");
            }
        }
    }

    public boolean inputLights() {
        System.out.println();
        System.out.println("Please enter the availability of lights at front and back (TRUE/FALSE)");

        while (true) {
            try {
                Boolean light = Boolean.parseBoolean(reader.readLine());
                return light;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputLights method");
                System.out.println("Enter correct data");
            }
        }

    }

    public String inputColour() {
        System.out.println();
        System.out.println("Please enter the colour");
        while (true) {
            try {
                String str = reader.readLine();
                return str;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputColour method");
                System.out.println("Enter correct data");
            }
        }
    }

    public BigDecimal inputPrice() {
        System.out.println();
        System.out.println("Please enter the price (EUR)");
        while (true) {
            try {
                BigDecimal price = new BigDecimal(Integer.valueOf(reader.readLine()));
                return price;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputPrice method");
                System.out.println("Enter correct data");
            }
        }
    }

    public Integer inputMaxSpeed() {
        System.out.println();
        System.out.println("Please enter the maximum speed (in km/h)");
        while (true) {
            try {
                Integer spd = Integer.parseInt(reader.readLine());
                return spd;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in input Brand method");
                System.out.println("Enter correct data");
            }
        }
    }

    public Integer inputBatteryCapacity() {
        System.out.println();
        System.out.println("Please enter the battery capacity (in mAh)");
        while (true) {
            try {

                Integer spd = Integer.parseInt(reader.readLine());
                return spd;

            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in input Battery Capacity method");
                System.out.println("Enter correct data");
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
                System.out.println("IOException in findBikeType");
                System.out.println("Enter correct data");
            }
        }
    }

    public String inputBrandFind() {
        System.out.println();
        System.out.println("Please enter the brand");
        while (true) {
            try {
                String str = reader.readLine();
                return str;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error in inputBrandFind method");
                System.out.println("Enter correct data");
            }
        }
    }
}
