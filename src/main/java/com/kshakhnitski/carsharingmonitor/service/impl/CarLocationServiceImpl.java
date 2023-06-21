package com.kshakhnitski.carsharingmonitor.service.impl;

import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import com.kshakhnitski.carsharingmonitor.repo.RegisteredCarRepo;
import com.kshakhnitski.carsharingmonitor.service.CarLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarLocationServiceImpl implements CarLocationService {
    private final RegisteredCarRepo registeredCarRepo;

    @Override
    public CarLocation updateCarLocation(RegisteredCar registeredCar, CarLocation carLocation) {
        registeredCar.setLocation(carLocation);
        return registeredCarRepo.save(registeredCar).getLocation();
    }

    @Override
    public void clearCarLocation(RegisteredCar registeredCar) {
        registeredCar.setLocation(null);
        registeredCarRepo.save(registeredCar);
    }
}
