package com.kshakhnitski.carsharingmonitor.dto.carsharingcompany;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CarSharingCompanyUpdateRequest {
    @Size(min = 2, max = 50, message = "Name must be between {min} and {max} characters long")
    private String name;

    @Size(max = 200, message = "Description must not exceed {max} characters")
    private String description;

    @Size(min = 10, max = 50, message = "Address must be between {min} and {max} characters long")
    private String address;

    private List<String> supportPhones;
}