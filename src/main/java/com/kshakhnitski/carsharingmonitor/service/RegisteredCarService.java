package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarDTO;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;

public interface RegisteredCarService {
    Iterable<RegisteredCar> getRegisteredCars();

    RegisteredCar getRegisteredCarById(Long registeredCarId);

    RegisteredCar createRegisteredCar(RegisteredCarDTO registeredCarDTO);

    RegisteredCar updateRegisteredCar(RegisteredCar registeredCar, RegisteredCarDTO registeredCarDTO);

    void deleteRegisteredCar(RegisteredCar registeredCar);
}
