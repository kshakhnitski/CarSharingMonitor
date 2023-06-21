package com.kshakhnitski.carsharingmonitor.dto.registeredcar;

import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisteredCarDTO {
    private String licensePlateNumber;
    private CarSharingCompany carSharingCompany;
    private CarModel carModel;
    private BigDecimal pricePerMinute;
    private CarLocation location;
    private Boolean isAvailable;
}
