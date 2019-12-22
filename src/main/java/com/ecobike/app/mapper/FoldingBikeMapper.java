package com.ecobike.app.mapper;

import com.ecobike.app.model.FoldingBike;

import java.math.BigDecimal;

public class FoldingBikeMapper {
    public FoldingBike toFoldingBike(String[] tokens) {
        return FoldingBike.builder()
                .brand(tokens[0])
                .wheelSize(Integer.valueOf(tokens[1].trim()))
                .numOfGears(Integer.valueOf(tokens[2].trim()))
                .weight(Integer.valueOf(tokens[3].trim()))
                .lights(Boolean.valueOf(tokens[4].trim()))
                .colour(tokens[5])
                .price(BigDecimal.valueOf(Long.valueOf(tokens[6].trim())))
                .build();
    }
}
