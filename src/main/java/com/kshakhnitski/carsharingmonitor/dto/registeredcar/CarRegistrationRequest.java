package com.kshakhnitski.carsharingmonitor.dto.registeredcar;

import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarRegistrationRequest {
    @NotNull(message = "License plate number cannot be null")
    @Size(min = 3, max = 50, message = "License plate number must be between {min} and {max} characters long")
    private String licensePlateNumber;

    @NotNull(message = "Car sharing company ID cannot be null")
    @Min(value = 0, message = "Car sharing company ID must have a value of {value} or greater")
    private Long carSharingCompanyId;

    @NotNull(message = "Car model ID cannot be null")
    @Min(value = 0, message = "Car model company ID must have a value of {value} or greater")
    private Long carModelId;

    @NotNull(message = "Price per minute cannot be null")
    @Digits(integer = 10, fraction = 2, message = "Price per minute must have a maximum of {integer} digits in total, with {fraction} digits after the decimal point")
    @DecimalMin(value = "0", message = "Price per minute must have non negative value")
    private BigDecimal pricePerMinute;

    private Boolean isAvailable = false;

    private CarLocation location;
}
