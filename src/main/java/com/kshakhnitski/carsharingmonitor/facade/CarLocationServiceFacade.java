package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationRequest;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;

public interface CarLocationServiceFacade {
    CarLocation getCarLocation(Long registeredCarId);

    CarLocation updateCarLocation(Long registeredCarId, CarLocationRequest updateRequest);

    void clearCarLocation(Long registeredCarId);
}
