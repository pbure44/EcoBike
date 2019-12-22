package com.ecobike.app.mapper;

import com.ecobike.app.model.EBike;

import java.math.BigDecimal;

public class EBikeMapper {
    public EBike toEBike(String[] tokens) {
        return EBike.builder()
                .brand(tokens[0])
                .maxSpeed(Integer.valueOf(tokens[1].trim()))
                .weight(Integer.valueOf(tokens[2].trim()))
                .lights(Boolean.valueOf(tokens[3].trim()))
                .batteryCapacity(Integer.valueOf(tokens[4].trim()))
                .colour(tokens[5])
                .price(BigDecimal.valueOf(Long.valueOf(tokens[6].trim())))
                .build();
    }
}
