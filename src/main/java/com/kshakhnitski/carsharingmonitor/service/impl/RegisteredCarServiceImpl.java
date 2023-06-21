package com.kshakhnitski.carsharingmonitor.service.impl;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarDTO;
import com.kshakhnitski.carsharingmonitor.exception.NotFoundException;
import com.kshakhnitski.carsharingmonitor.mapper.RegisteredCarMapper;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import com.kshakhnitski.carsharingmonitor.repo.RegisteredCarRepo;
import com.kshakhnitski.carsharingmonitor.service.RegisteredCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisteredCarServiceImpl implements RegisteredCarService {
    private final RegisteredCarRepo registeredCarRepo;
    private final RegisteredCarMapper mapper;

    @Override
    public Iterable<RegisteredCar> getRegisteredCars() {
        return registeredCarRepo.findAll();
    }

    @Override
    public RegisteredCar getRegisteredCarById(Long registeredCarId) {
        return registeredCarRepo.findById(registeredCarId)
                .orElseThrow(() -> new NotFoundException("Registered car with ID " + registeredCarId + " not found"));
    }

    @Override
    public RegisteredCar createRegisteredCar(RegisteredCarDTO registeredCarDTO) {
        RegisteredCar registeredCar = mapper.toEntity(registeredCarDTO);
        return registeredCarRepo.save(registeredCar);
    }

    @Override
    public RegisteredCar updateRegisteredCar(RegisteredCar registeredCar, RegisteredCarDTO registeredCarDTO) {
        mapper.update(registeredCar, registeredCarDTO);
        return registeredCarRepo.save(registeredCar);
    }

    @Override
    public void deleteRegisteredCar(RegisteredCar registeredCar) {
        registeredCarRepo.delete(registeredCar);
    }
}
