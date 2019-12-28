package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EBike extends AbstractBike {
    @NotNull(message = "Max speed must not be null")
    @Positive(message = "Max speed must be positive number")
    private Integer maxSpeed;
    @NotNull(message = "Battery capacity must not be null")
    @Positive(message = "Battery capacity must be positive number")
    private Integer batteryCapacity;


    @Builder
    public EBike(String brand, int weight, boolean lights, String colour, BigDecimal price, int maxSpeed, int batteryCapacity) {
        super(brand, weight, lights, colour, price);
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return super.getBrand() + " with " + batteryCapacity + " mAh battery and " + (super.getLights() ? "no" : "") +
                " head/tail light.\n" + "Price: " + super.getPrice() + " euros.";
    }

    @Override
    public String toList() {
        return super.getBrand() + "; " + maxSpeed + "; " + super.getWeight() + "; " + super.getLights() + "; " + batteryCapacity + "; " + super.getColour() + "; " + super.getPrice();
    }
}
