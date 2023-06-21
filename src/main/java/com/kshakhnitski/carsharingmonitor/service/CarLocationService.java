package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;

public interface CarLocationService {
    CarLocation updateCarLocation(RegisteredCar registeredCar, CarLocation carLocation);

    void clearCarLocation(RegisteredCar registeredCar);
}
