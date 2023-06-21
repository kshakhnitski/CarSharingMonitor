package com.kshakhnitski.carsharingmonitor.dto.carmodel;

import com.kshakhnitski.carsharingmonitor.model.FuelType;
import com.kshakhnitski.carsharingmonitor.model.TransmissionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarModelUpdateRequest {
    @Size(min = 2, max = 50, message = "Model must be between {min} and {max} characters long")
    private String model;

    @Min(value = 0, message = "Manufacturer ID must have a value of {value} or greater")
    private Long manufacturerId;

    @Min(value = 1, message = "Seats must have a value of {value} or greater")
    private Integer seats;

    private FuelType fuelType;

    private TransmissionType transmissionType;
}
