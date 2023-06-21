package com.kshakhnitski.carsharingmonitor.dto.carmodel;

import com.kshakhnitski.carsharingmonitor.model.FuelType;
import com.kshakhnitski.carsharingmonitor.model.TransmissionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarModelCreateRequest {
    @NotNull(message = "Model cannot be null")
    @Size(min = 2, max = 50, message = "Model must be between {min} and {max} characters long")
    private String model;

    @NotNull(message = "Manufacturer ID cannot be null")
    @Min(value = 0, message = "Manufacturer ID must have a value of {value} or greater")
    private Long manufacturerId;

    @NotNull(message = "Seats cannot be null")
    @Min(value = 1, message = "Seats must have a value of {value} or greater")
    private Integer seats;

    @NotNull(message = "Fuel type cannot be null")
    private FuelType fuelType;

    @NotNull(message = "Transmission type cannot be null")
    private TransmissionType transmissionType;
}
