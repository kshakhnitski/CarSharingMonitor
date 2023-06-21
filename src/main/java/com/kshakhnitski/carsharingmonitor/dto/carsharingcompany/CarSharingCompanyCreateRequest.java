package com.kshakhnitski.carsharingmonitor.dto.carsharingcompany;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CarSharingCompanyCreateRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between {min} and {max} characters long")
    private String name;

    @NotNull(message = "Description cannot be null")
    @Size(max = 200, message = "Description must not exceed {max} characters")
    private String description;

    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 50, message = "Address must be between {min} and {max} characters long")
    private String address;

    private List<String> supportPhones;
}