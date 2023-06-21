package com.kshakhnitski.carsharingmonitor.dto.carlocation;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarLocationUpdateRequest {
    @NotNull(message = "Latitude cannot be null")
    private Double latitude;

    @NotNull(message = "Longitude cannot be null")
    private Double longitude;
}
