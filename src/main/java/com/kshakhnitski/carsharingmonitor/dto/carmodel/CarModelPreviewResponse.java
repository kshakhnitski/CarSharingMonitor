package com.kshakhnitski.carsharingmonitor.dto.carmodel;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import lombok.Data;

@Data
public class CarModelPreviewResponse {
    private Long id;
    private ManufacturerResponse manufacturer;
    private String model;
}
