package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinearSearch {

    public void linearSearch(AbstractBike searchBike, List<AbstractBike> bikeList) {
        int indexFirst = 0;
        int index2 = bikeList.size() / 4;
        int index3 = bikeList.size() / 2;
        int index4 = bikeList.size() * 3 / 4;
        int indexLast = bikeList.size() - 1;
        SearchThread searchThreadOne = new SearchThread(indexFirst, index2 - 1, searchBike, bikeList, "Thread One");
        SearchThread searchThreadTwo = new SearchThread(index2, index3 - 1, searchBike, bikeList, "Thread Two");
        SearchThread searchThreadThree = new SearchThread(index3, index4 - 1, searchBike, bikeList, "Thread Three");
        SearchThread searchThreadFour = new SearchThread(index4, indexLast, searchBike, bikeList, "Thread Four");
        searchThreadOne.run();
        searchThreadTwo.run();
        searchThreadThree.run();
        searchThreadFour.run();
    }

}
