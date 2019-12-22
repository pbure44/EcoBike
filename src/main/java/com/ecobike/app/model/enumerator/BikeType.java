package com.ecobike.app.model.enumerator;

public enum BikeType {
    SPEEDELEC("SPEEDELEC"),
    E_BIKE("E-BIKE"),
    FOLDING_BIKE("FOLDING BIKE");

    private String bikeType;

    BikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getBikeType() {
        return bikeType;
    }
}
