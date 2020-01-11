package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FoldingBike extends AbstractBike {
    @NotNull(message = "Size of weels must not be null")
    @Positive(message = "Size of weels must be positive number")
    private Integer wheelSize;
    @NotNull(message = "Number of Gears must not be null")
    @Positive(message = "Number of Gears must be positive number")
    private Integer numOfGears;

    @Builder
    public FoldingBike(String type, String brand, int wheelSize, int numOfGears, int weight, Boolean lights, String colour, BigDecimal price) {
        super(type, brand, weight, lights, colour, price);
        this.wheelSize = wheelSize;
        this.numOfGears = numOfGears;
    }

    @Override
    public String toString() {
        return super.getType() +" "+super.getBrand() + "; with " + numOfGears + " gear(s) and " + (super.getLights() ? "" : "no ") +
                "head/tail light.\n" + "Price: " + super.getPrice() + " euros.";
    }

    @Override
    public String toList() {
        return super.getType() +" "+super.getBrand() + "; " + wheelSize + "; " + numOfGears + "; " + super.getWeight() + "; " + super.getLights() + "; " + super.getColour() + "; " + super.getPrice();
    }
}
