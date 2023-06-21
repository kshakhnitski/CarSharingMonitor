package com.kshakhnitski.carsharingmonitor.dto.carmodel;

import com.kshakhnitski.carsharingmonitor.model.FuelType;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import com.kshakhnitski.carsharingmonitor.model.TransmissionType;
import lombok.Data;

@Data
public class CarModelDTO {
    private String model;
    private Manufacturer manufacturer;
    private Integer seats;
    private FuelType fuelType;
    private TransmissionType transmissionType;
}
