package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FoldingBike extends AbstractBike {
    private int wheelSize;
    private int numOfGears;

    @Builder
    public FoldingBike(String brand, int weight, boolean lights, String colour, BigDecimal price, int wheelSize, int numOfGears) {
        super(brand, weight, lights, colour, price);
        this.wheelSize = wheelSize;
        this.numOfGears = numOfGears;
    }

    @Override
    public String toString() {
        return super.getBrand() + "; with " + numOfGears + " gear(s) and " + super.isLights() +
                " head/tail light.\n" + "Price: " + super.getPrice() + " euros.";
    }

    @Override
    public String toList() {
        return super.getBrand() + "; " + wheelSize + "; " + numOfGears + "; " + super.getWeight() + "; " + super.isLights() + "; " + super.getColour() + "; " + super.getPrice();
    }
}
