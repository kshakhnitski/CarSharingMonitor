package com.kshakhnitski.carsharingmonitor.facade.impl;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.CarRegistrationRequest;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarDTO;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarResponse;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.RegisteredCarServiceFacade;
import com.kshakhnitski.carsharingmonitor.mapper.RegisteredCarMapper;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import com.kshakhnitski.carsharingmonitor.service.CarModelService;
import com.kshakhnitski.carsharingmonitor.service.CarSharingCompanyService;
import com.kshakhnitski.carsharingmonitor.service.RegisteredCarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisteredCarServiceFacadeImpl implements RegisteredCarServiceFacade {
    private final RegisteredCarService registeredCarService;
    private final CarModelService carModelService;
    private final CarSharingCompanyService carSharingCompanyService;
    private final RegisteredCarMapper mapper;

    @Override
    public Iterable<RegisteredCarResponse> getRegisteredCars() {
        Iterable<RegisteredCar> registeredCars = registeredCarService.getRegisteredCars();
        return mapper.toResponse(registeredCars);
    }

    @Override
    public RegisteredCarResponse getRegisteredCar(Long registeredCarId) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);
        return mapper.toResponse(registeredCar);
    }

    @Override
    public RegisteredCarResponse registerCar(CarRegistrationRequest registrationRequest) {
        CarSharingCompany carSharingCompany = carSharingCompanyService.getCarSharingCompanyById(
                registrationRequest.getCarSharingCompanyId());
        CarModel carModel = carModelService.getCarModelById(registrationRequest.getCarModelId());
        RegisteredCarDTO registeredCarDTO = mapper.toDTO(registrationRequest, carSharingCompany, carModel);
        RegisteredCar registeredCar = registeredCarService.createRegisteredCar(registeredCarDTO);
        return mapper.toResponse(registeredCar);
    }

    @Override
    public RegisteredCarResponse updateRegisteredCar(Long registeredCarId, RegisteredCarUpdateRequest updateRequest) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);

        CarSharingCompany carSharingCompany = (updateRequest.getCarSharingCompanyId() == null) ? null :
                carSharingCompanyService.getCarSharingCompanyById(updateRequest.getCarSharingCompanyId());
        CarModel carModel = (updateRequest.getCarModelId() == null) ? null :
                carModelService.getCarModelById(updateRequest.getCarModelId());
        RegisteredCarDTO registeredCarDTO = mapper.toDTO(updateRequest, carSharingCompany, carModel);

        registeredCar = registeredCarService.updateRegisteredCar(registeredCar, registeredCarDTO);
        return mapper.toResponse(registeredCar);
    }

    @Override
    public void deleteRegisteredCar(Long registeredCarId) {
        RegisteredCar registeredCar = registeredCarService.getRegisteredCarById(registeredCarId);
        registeredCarService.deleteRegisteredCar(registeredCar);
    }
}
