package com.kshakhnitski.carsharingmonitor.dto.manufactuer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ManufacturerCreateRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between {min} and {max} characters long")
    private String name;
}
