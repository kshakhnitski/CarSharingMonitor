package com.kshakhnitski.carsharingmonitor.dto.carlocation;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarLocationRequest {
    @NotNull(message = "Latitude cannot be null")
    @DecimalMin(value = "-90", message = "Latitude must have a value of {value} or greater")
    @DecimalMax(value = "90", message = "Latitude must have a value of {value} or less")
    private Double latitude;

    @NotNull(message = "Longitude cannot be null")
    @DecimalMin(value = "-180", message = "Longitude must have a value of {value} or greater")
    @DecimalMax(value = "180", message = "Longitude must have a value of {value} or less")
    private Double longitude;
}
