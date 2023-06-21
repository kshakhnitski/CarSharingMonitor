package com.kshakhnitski.carsharingmonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CarLocation {
    @Column(name = "car_location_latitude")
    private Double latitude;

    @Column(name = "car_location_longitude")
    private Double longitude;
}
