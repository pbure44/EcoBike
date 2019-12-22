package com.ecobike.app.service.impl;

import com.ecobike.app.model.AbstractBike;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortService implements Comparator<AbstractBike> {



    @Override
    public int compare(AbstractBike o1, AbstractBike o2) {     //компаратор на несколько полей сделать
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
