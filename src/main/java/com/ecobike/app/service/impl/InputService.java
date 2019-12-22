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

    public String inputBrand(AbstractBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the Brand name");
        try {
            if(bike.getClass().equals(EBike.class)) {
                bike.setBrand("E-BIKE " + reader.readLine());
            } else if(bike.getClass().equals(FoldingBike.class)){
                bike.setBrand("FOLDING BIKE " + reader.readLine());
            } else if (bike.getClass().equals(SpeedElec.class)) {
                bike.setBrand("SPEEDELEC " + reader.readLine());
            }else {
                throw new IOException();
            }
        }catch (IOException e){
            System.out.println("Error in input Brand method");
        }
    }

    public void inputWheelSize(FoldingBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the size of the wheels (in inch)");
        try {
            bike.setWheelSize(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Error in inputWheelSize method");;
        }
    }

    public void inputNumOfGears(FoldingBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the number of Gears ");
        try {
            bike.setNumOfGears(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Error in inputNumOfGears method");;
        }
    }

    public void inputWeight(AbstractBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the weight of the bike (in grams)");
        try {
            bike.setWeight(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Error in inputWeight method");;
        }
    }

    public void inputLights (AbstractBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the availability of lights at front and back (TRUE/FALSE)");
        try {
            bike.setLights(Boolean.parseBoolean(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Error in inputLights method");
        }
    }

    public void inputColour(AbstractBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the colour");
        try {
            bike.setColour(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error in inputColour method");
        }
    }

    public void inputPrice(AbstractBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the price (EUR)");
        try {
            bike.setPrice(new BigDecimal(Integer.valueOf(reader.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inputMaxSpeed(EBike bike){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Please enter the maximum speed (in km/h)");
        try {
            bike.setMaxSpeed(Integer.parseInt(reader.readLine()));
        }catch (IOException e){
            System.out.println("Error in input Brand method");
        }
    }
}
