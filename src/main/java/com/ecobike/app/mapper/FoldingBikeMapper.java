package com.ecobike.app.mapper;

import com.ecobike.app.model.FoldingBike;

import java.math.BigDecimal;

public class FoldingBikeMapper {
    public FoldingBike toFoldingBike(String[] tokens) {
        return FoldingBike.builder()
                .type(tokens[0])
                .brand(tokens[1].trim())
                .wheelSize(Integer.valueOf(tokens[2].trim()))
                .numOfGears(Integer.valueOf(tokens[3].trim()))
                .weight(Integer.valueOf(tokens[4].trim()))
                .lights(Boolean.valueOf(tokens[5].trim()))
                .colour(tokens[6])
                .price(BigDecimal.valueOf(Long.valueOf(tokens[7].trim())))
                .build();
    }
}
