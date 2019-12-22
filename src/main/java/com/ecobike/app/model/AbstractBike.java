package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractBike {
    private String brand;
    private int weight;
    private boolean lights;
    private String colour;
    private BigDecimal price;

    @Override
    public String toString() {
        return "AbstractBike{" +
                "brand='" + brand + '\'' +
                ", weight=" + weight +
                ", lights=" + lights +
                ", colour='" + colour + '\'' +
                ",\n Price: " + price +
                " euros.";
    }

    public String toList(){
        return "AbstractBike{" +
                "brand='" + brand + '\'' +
                ", weight=" + weight +
                ", lights=" + lights +
                ", colour='" + colour + '\'' +
                ",\n Price: " + price +
                " euros.";
    }
}
