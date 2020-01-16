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
    private String threadName;

    public SearchThread(int startIndex, int endIndex, AbstractBike searchBike, List<AbstractBike> bikeList, String threadName) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.searchBike = searchBike;
        this.bikeList = bikeList;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        AbstractBike bike = bikeCheck();
        if (bike != null) {
            System.out.println(threadName + " - There is such bike:\n" + bike);
        } else {
            System.out.println(threadName + " - Such bike NOT FOUND");
        }

    }

    private AbstractBike bikeCheck() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (checkParameters(bikeList.get(i))) {
                return bikeList.get(i);
            }
        }
        return null;
    }

    private boolean checkParameters(AbstractBike existedBike) {
        return existedBike.equals(searchBike);
    }

}