package com.ecobike.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractBike {
    @NotBlank(message = "Brand field required")
    private String type;
    @NotBlank(message = "Brand field required")
    private String brand;
    @NotNull(message = "Weight must not be null")
    @Positive(message = "Weight must be positive number")
    private Integer weight;
    @NotNull(message = "Lights must not be null")
    private Boolean lights;
    @NotNull(message = "Colour required")
    private String colour;
    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be positive number")
    private BigDecimal price;

    @Override
    public String toString() {
        return "AbstractBike{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", lights=" + lights +
                ", colour='" + colour + '\'' +
                ",\n Price: " + price +
                " euros.";
    }

    public abstract String format();
}
