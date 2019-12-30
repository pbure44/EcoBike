package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.ecobike.app.model.EBike;
import com.ecobike.app.model.FoldingBike;
import com.ecobike.app.model.SpeedElec;

import java.util.List;

public class SearchThread implements Runnable {
    private int startIndex;
    private int endIndex;
    private AbstractBike searchBike;
    private List<AbstractBike> bikeList;

    public String getThreadName() {
        return threadName;
    }

    private String threadName;

    public SearchThread(int startIndex, int endIndex, AbstractBike searchBike, List<AbstractBike> bikeList, String threadName) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.searchBike = searchBike;
        this.bikeList = bikeList;
        this.threadName=threadName;
    }

    @Override
    public void run() {
        boolean flag = false;
        for (int i = startIndex; i <= endIndex; i++) {
            if (checkParameters(bikeList.get(i))){
                flag=true;
                System.out.println("There is such bike"+bikeList.get(i));
                return;
            }
            if(!flag){
                System.out.println("There is no such bike in this thread - "+getThreadName());
            }

        }
    }

    private boolean checkParameters(AbstractBike existedBike) {
        if (!existedBike.getBrand().equalsIgnoreCase(searchBike.getBrand())) return false;
        if (!existedBike.getWeight().equals(searchBike.getWeight())) return false;
        if (!existedBike.getLights().equals(searchBike.getLights())) return false;
        if (!existedBike.getColour().equalsIgnoreCase(searchBike.getColour())) return false;
        if (!existedBike.getPrice().equals(searchBike.getPrice())) return false;
        if (existedBike.getClass().equals(EBike.class) && searchBike.getClass().equals(EBike.class)) {
            return checkEBikeParameters(existedBike);
        } else if (existedBike.getClass().equals(SpeedElec.class) && searchBike.getClass().equals(SpeedElec.class)) {
            return checkSpeedElecParameters(existedBike);
        } else if (existedBike.getClass().equals(FoldingBike.class) && searchBike.getClass().equals(FoldingBike.class)) {
            return checkFoldingBikeParameters(existedBike);
        }
        return true;
    }

    private boolean checkEBikeParameters(AbstractBike existedBike) {
        EBike existBike = (EBike) existedBike;
        EBike srchBike = (EBike) searchBike;
        if (!existBike.getMaxSpeed().equals(srchBike.getMaxSpeed())) return false;
        if (!existBike.getBatteryCapacity().equals(srchBike.getBatteryCapacity())) return false;
        return true;
    }

    private boolean checkSpeedElecParameters(AbstractBike existedBike) {
        SpeedElec existBike = (SpeedElec) existedBike;
        SpeedElec srchBike = (SpeedElec) searchBike;
        if (!existBike.getMaxSpeed().equals(srchBike.getMaxSpeed())) return false;
        if (!existBike.getBatteryCapacity().equals(srchBike.getBatteryCapacity())) return false;
        return true;
    }

    private boolean checkFoldingBikeParameters(AbstractBike existedBike) {
        FoldingBike existBike = (FoldingBike) existedBike;
        FoldingBike srchBike = (FoldingBike) searchBike;
        if (!existBike.getWheelSize().equals(srchBike.getWheelSize())) return false;
        if (!existBike.getNumOfGears().equals(srchBike.getNumOfGears())) return false;
        return true;
    }

}