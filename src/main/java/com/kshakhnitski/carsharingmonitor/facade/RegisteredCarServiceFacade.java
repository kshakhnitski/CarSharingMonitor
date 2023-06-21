package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.CarRegistrationRequest;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarResponse;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegisteredCarServiceFacade {
    Page<RegisteredCarResponse> getRegisteredCars(Pageable pageable);

    RegisteredCarResponse getRegisteredCar(Long registeredCarId);

    RegisteredCarResponse registerCar(CarRegistrationRequest registrationRequest);

    RegisteredCarResponse updateRegisteredCar(Long registeredCarId, RegisteredCarUpdateRequest updateRequest);

    void deleteRegisteredCar(Long registeredCarId);
}
