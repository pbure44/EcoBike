package com.ecobike.app.mapper;

import com.ecobike.app.model.EBike;

import java.math.BigDecimal;

public class EBikeMapper {
    public EBike toEBike(String[] tokens) {
        return EBike.builder()
                .type(tokens[0])
                .brand(tokens[1].trim())
                .maxSpeed(Integer.valueOf(tokens[2].trim()))
                .weight(Integer.valueOf(tokens[3].trim()))
                .lights(Boolean.valueOf(tokens[4].trim()))
                .batteryCapacity(Integer.valueOf(tokens[5].trim()))
                .colour(tokens[6])
                .price(BigDecimal.valueOf(Long.valueOf(tokens[7].trim())))
                .build();
    }
}
