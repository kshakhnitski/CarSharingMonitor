package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarDTO;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegisteredCarService {
    Page<RegisteredCar> getRegisteredCars(Pageable pageable);

    RegisteredCar getRegisteredCarById(Long registeredCarId);

    RegisteredCar createRegisteredCar(RegisteredCarDTO registeredCarDTO);

    RegisteredCar updateRegisteredCar(RegisteredCar registeredCar, RegisteredCarDTO registeredCarDTO);

    void deleteRegisteredCar(RegisteredCar registeredCar);
}
