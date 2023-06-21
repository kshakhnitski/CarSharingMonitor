package com.kshakhnitski.carsharingmonitor.facade.impl;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyDTO;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyResponse;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarSharingCompanyServiceFacade;
import com.kshakhnitski.carsharingmonitor.mapper.CarSharingCompanyMapper;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import com.kshakhnitski.carsharingmonitor.service.CarSharingCompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CarSharingCompanyServiceFacadeImpl implements CarSharingCompanyServiceFacade {
    private final CarSharingCompanyService carSharingCompanyService;
    private final CarSharingCompanyMapper mapper;

    @Override
    public Iterable<CarSharingCompanyResponse> getCarSharingCompanies() {
        Iterable<CarSharingCompany> carSharingCompanies = carSharingCompanyService.getCarSharingCompanies();
        return mapper.toResponse(carSharingCompanies);
    }

    @Override
    public CarSharingCompanyResponse getCarSharingCompany(Long carSharingCompanyId) {
        CarSharingCompany carSharingCompany = carSharingCompanyService.getCarSharingCompanyById(carSharingCompanyId);
        return mapper.toResponse(carSharingCompany);
    }

    @Override
    public CarSharingCompanyResponse createCarSharingCompany(CarSharingCompanyCreateRequest createRequest) {
        CarSharingCompanyDTO carSharingCompanyDTO = mapper.toDTO(createRequest);
        CarSharingCompany carSharingCompany = carSharingCompanyService.createCarSharingCompany(carSharingCompanyDTO);
        return mapper.toResponse(carSharingCompany);
    }

    @Override
    public CarSharingCompanyResponse updateCarSharingCompany(Long carSharingCompanyId, CarSharingCompanyUpdateRequest updateRequest) {
        CarSharingCompany carSharingCompany = carSharingCompanyService.getCarSharingCompanyById(carSharingCompanyId);
        CarSharingCompanyDTO carSharingCompanyDTO = mapper.toDTO(updateRequest);
        carSharingCompany = carSharingCompanyService.updateCarSharingCompany(carSharingCompany, carSharingCompanyDTO);
        return mapper.toResponse(carSharingCompany);
    }

    @Override
    public void deleteCarSharingCompany(Long carSharingCompanyId) {
        CarSharingCompany carSharingCompany = carSharingCompanyService.getCarSharingCompanyById(carSharingCompanyId);
        carSharingCompanyService.deleteCarSharingCompany(carSharingCompany);
    }
}
