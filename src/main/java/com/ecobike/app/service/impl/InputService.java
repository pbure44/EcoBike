package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
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

    public String inputBrand(Class bikeClass) {
        System.out.println();
        System.out.println("Please enter the Brand name");
        try {
            if (bikeClass.equals(EBike.class)) {
                String str = "E-BIKE " + reader.readLine();
                return str;
            } else if (bikeClass.equals(FoldingBike.class)) {
                String str = "FOLDING BIKE " + reader.readLine();
                return str;
            } else if (bikeClass.equals(SpeedElec.class)) {
                String str = "SPEEDELEC " + reader.readLine();
                return str;
            } else {
                System.out.println("Wrong parameter 'bikeClass'");
            }
        } catch (IOException e) {
            System.out.println("Error in input Brand method");
        }
        return "-1";
    }

    public Integer inputWheelSize() {
        System.out.println();
        System.out.println("Please enter the size of the wheels (in inch)");
        try {
            Integer size = Integer.parseInt(reader.readLine());
            return size;
        } catch (IOException e) {
            System.out.println("Error in inputWheelSize method");
        }
        return -1;
    }

    public Integer inputNumOfGears() {
        System.out.println();
        System.out.println("Please enter the number of Gears ");
        try {
            Integer num = Integer.parseInt(reader.readLine());
            return num;
        } catch (IOException e) {
            System.out.println("Error in inputNumOfGears method");
        }
        return -1;
    }

    public Integer inputWeight() {
        System.out.println();
        System.out.println("Please enter the weight of the bike (in grams)");
        try {
            Integer wght = Integer.parseInt(reader.readLine());
            return wght;
        } catch (IOException e) {
            System.out.println("Error in inputWeight method");
        }
        return -1;
    }

    public boolean inputLights() {
        System.out.println();
        System.out.println("Please enter the availability of lights at front and back (TRUE/FALSE)");
        try {
            Boolean light = Boolean.parseBoolean(reader.readLine());
            return light;
        } catch (IOException e) {
            System.out.println("Error in inputLights method");
        }
        return false;
    }

    public String inputColour() {
        System.out.println();
        System.out.println("Please enter the colour");
        try {
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            System.out.println("Error in inputColour method");
        }
        return "-1";
    }

    public BigDecimal inputPrice() {
        System.out.println();
        System.out.println("Please enter the price (EUR)");
        try {
            BigDecimal price = new BigDecimal(Integer.valueOf(reader.readLine()));
            return price;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BigDecimal.valueOf(-1);
    }

    public Integer inputMaxSpeed() {
        System.out.println();
        System.out.println("Please enter the maximum speed (in km/h)");
        try {
            Integer spd = Integer.parseInt(reader.readLine());
            return spd;
        } catch (IOException e) {
            System.out.println("Error in input Brand method");
        }
        return -1;
    }

    public Integer inputBatteryCapacity() {
        System.out.println();
        System.out.println("Please enter the battery capacity (in mAh)");
        try {
            Integer spd = Integer.parseInt(reader.readLine());
            return spd;
        } catch (IOException e) {
            System.out.println("Error in input Battery Capacity method");
        }
        return -1;
    }

    public Class findBikeType() {
        System.out.println("Please enter the number of type of bike:\n+" +
                "1 - E-Bike\n" +
                "2 - Folding Bike\n" +
                "3 - SpeedElec\n");
        try {
            //можно ли сделать проверку, что введена цифра от 1 до 3, через аннотацию
            switch (Integer.parseInt(reader.readLine())) {
                case 1:
                    return EBike.class;
                case 2:
                    return FoldingBike.class;
                case 3:
                    return SpeedElec.class;
                default:
                    System.out.println("Please enter a number: 1 or 2 or 3");
            }
        } catch (IOException e) {
            System.out.println("IOException in findBikeType");
        }
        return null;         //так правильно??
    }

    public String inputBrandFind() {
        System.out.println();
        System.out.println("Please enter the brand");
        try {
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            System.out.println("Error in inputBrandFind method");
        }
        return "-1";
    }
}
