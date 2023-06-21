package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.CarRegistrationRequest;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarResponse;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarUpdateRequest;

public interface RegisteredCarServiceFacade {
    Iterable<RegisteredCarResponse> getRegisteredCars();

    RegisteredCarResponse getRegisteredCar(Long registeredCarId);

    RegisteredCarResponse registerCar(CarRegistrationRequest registrationRequest);

    RegisteredCarResponse updateRegisteredCar(Long registeredCarId, RegisteredCarUpdateRequest updateRequest);

    void deleteRegisteredCar(Long registeredCarId);
}
