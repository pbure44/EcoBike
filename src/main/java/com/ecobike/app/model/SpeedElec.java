package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SpeedElec extends AbstractBike {
    private int maxSpeed;
    private int batteryCapacity;

    @Builder
    public SpeedElec(String brand, int weight, boolean lights, String colour, BigDecimal price, int maxSpeed, int batteryCapacity) {
        super(brand, weight, lights, colour, price);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return super.getBrand() + " with " + batteryCapacity + " mAh battery and " + super.isLights() +
                " head/tail light.\n" + "Price: " + super.getPrice() + " euros.";
    }

    @Override
    public String toList() {
        return super.getBrand() + "; " + maxSpeed + "; " + super.getWeight() + "; " + super.isLights() + "; " + batteryCapacity + "; " + super.getColour() + "; " + super.getPrice();
    }
}
