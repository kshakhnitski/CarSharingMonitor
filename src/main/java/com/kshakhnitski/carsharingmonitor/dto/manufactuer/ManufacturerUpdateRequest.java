package com.kshakhnitski.carsharingmonitor.dto.manufactuer;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ManufacturerUpdateRequest {
    @Size(min = 2, max = 50, message = "Name must be between {min} and {max} characters long")
    private String name;
}
