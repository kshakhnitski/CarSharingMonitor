package com.kshakhnitski.carsharingmonitor.service.impl;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyDTO;
import com.kshakhnitski.carsharingmonitor.exception.NotFoundException;
import com.kshakhnitski.carsharingmonitor.mapper.CarSharingCompanyMapper;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import com.kshakhnitski.carsharingmonitor.repo.CarSharingCompanyRepo;
import com.kshakhnitski.carsharingmonitor.service.CarSharingCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarSharingCompanyServiceImpl implements CarSharingCompanyService {
    private final CarSharingCompanyRepo carSharingCompanyRepo;
    private final CarSharingCompanyMapper mapper;

    @Override
    public Iterable<CarSharingCompany> getCarSharingCompanies() {
        return carSharingCompanyRepo.findAll();
    }

    @Override
    public CarSharingCompany getCarSharingCompanyById(Long carSharingCompanyId) {
        return carSharingCompanyRepo.findById(carSharingCompanyId)
                .orElseThrow(() -> new NotFoundException("Car sharing company with ID " + carSharingCompanyId + " not found"));
    }

    @Override
    public CarSharingCompany createCarSharingCompany(CarSharingCompanyDTO carSharingCompanyDTO) {
        CarSharingCompany carSharingCompany = mapper.toEntity(carSharingCompanyDTO);
        return carSharingCompanyRepo.save(carSharingCompany);
    }

    @Override
    public CarSharingCompany updateCarSharingCompany(CarSharingCompany carSharingCompany, CarSharingCompanyDTO carSharingCompanyDTO) {
        mapper.update(carSharingCompany, carSharingCompanyDTO);
        return carSharingCompanyRepo.save(carSharingCompany);
    }

    @Override
    public void deleteCarSharingCompany(CarSharingCompany carSharingCompany) {
        carSharingCompanyRepo.delete(carSharingCompany);
    }
}
