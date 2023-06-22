package com.kshakhnitski.carsharingmonitor.facade.impl;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarLocationServiceFacade;
import com.kshakhnitski.carsharingmonitor.mapper.CarLocationMapper;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import com.kshakhnitski.carsharingmonitor.service.CarLocationService;
import com.kshakhnitski.carsharingmonitor.service.RegisteredCarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CarLocationServiceFacadeImpl implements CarLocationServiceFacade {
    private final RegisteredCarService registeredCarService;
    private final CarLocationService carLocationService;
    private final CarLocationMapper carLocationMapper;

    @Override
    public CarLocation getCarLocation(Long registeredCarId) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);
        return registeredCar.getLocation();
    }

    @Override
    public CarLocation updateCarLocation(Long registeredCarId, CarLocationRequest updateRequest) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);
        CarLocation carLocation = carLocationMapper.toEmbeddable(updateRequest);
        carLocation = carLocationService.updateCarLocation(registeredCar, carLocation);
        return carLocation;
    }

    @Override
    public void clearCarLocation(Long registeredCarId) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);
        carLocationService.clearCarLocation(registeredCar);
    }
}
