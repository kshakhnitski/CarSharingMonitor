package com.kshakhnitski.carsharingmonitor.dto.carmodel;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.model.FuelType;
import com.kshakhnitski.carsharingmonitor.model.TransmissionType;
import lombok.Data;

@Data
public class CarModelResponse {
    private Long id;
    private String model;
    private ManufacturerResponse manufacturer;
    private Integer seats;
    private FuelType fuelType;
    private TransmissionType transmissionType;
}
