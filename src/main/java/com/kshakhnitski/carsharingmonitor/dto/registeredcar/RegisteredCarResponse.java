package com.kshakhnitski.carsharingmonitor.dto.registeredcar;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelPreviewResponse;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyPreviewResponse;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisteredCarResponse {
    private Long id;
    private String licensePlateNumber;
    private CarSharingCompanyPreviewResponse carSharingCompany;
    private CarModelPreviewResponse carModel;
    private BigDecimal pricePerMinute;
    private CarLocation location;
    private Boolean isAvailable;
}
