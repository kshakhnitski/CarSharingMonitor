package com.kshakhnitski.carsharingmonitor.dto.registeredcar;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisteredCarUpdateRequest {
    @Size(min = 3, max = 50, message = "License plate number must be between {min} and {max} characters long")
    private String licensePlateNumber;

    @Min(value = 0, message = "Car sharing company ID must have a value of {value} or greater")
    private Long carSharingCompanyId;

    @Min(value = 0, message = "Car model company ID must have a value of {value} or greater")
    private Long carModelId;

    @Digits(integer = 10, fraction = 2, message = "Price per minute must have a maximum of {integer} digits in total, with {fraction} digits after the decimal point")
    @DecimalMin(value = "0", message = "Price per minute must have non negative value")
    private BigDecimal pricePerMinute;

    private Boolean isAvailable;
}
