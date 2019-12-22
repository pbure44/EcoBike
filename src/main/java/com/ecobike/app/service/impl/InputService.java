package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class InputService {

    public String inputBrand(Class bikeClass) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the Brand name");
        try {
            if (bikeClass.equals(EBike.class)) {
                String str = "E-BIKE " + reader.readLine();
                return str;
            } else if (bikeClass.equals(FoldingBike.class)) {
                String str="FOLDING BIKE " + reader.readLine();
                return str;
            } else if (bikeClass.equals(SpeedElec.class)) {
                String str ="SPEEDELEC " + reader.readLine();
                return str;
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("Error in input Brand method");
        }
        return "-1";
    }

    public Integer inputWheelSize() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the size of the wheels (in inch)");
        try {
            Integer size =Integer.parseInt(reader.readLine());
            return size;
        } catch (IOException e) {
            System.out.println("Error in inputWheelSize method");
        }
        return -1;
    }

    public Integer inputNumOfGears() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the number of Gears ");
        try {
            Integer num =Integer.parseInt(reader.readLine());
            return num;
        } catch (IOException e) {
            System.out.println("Error in inputNumOfGears method");
        }
        return -1;
    }

    public Integer inputWeight() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the availability of lights at front and back (TRUE/FALSE)");
        try {
            Boolean light =Boolean.parseBoolean(reader.readLine());
            return light;
        } catch (IOException e) {
            System.out.println("Error in inputLights method");
        }
        return false;
    }

    public String inputColour() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the maximum speed (in km/h)");
        try {
            Integer spd=Integer.parseInt(reader.readLine());
            return spd;
        } catch (IOException e) {
            System.out.println("Error in input Brand method");
        }
        return -1;
    }
}
