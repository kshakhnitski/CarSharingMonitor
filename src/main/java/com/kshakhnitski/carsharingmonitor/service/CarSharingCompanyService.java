package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyDTO;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarSharingCompanyService {
    Page<CarSharingCompany> getCarSharingCompanies(Pageable pageable);

    CarSharingCompany getCarSharingCompanyById(Long carSharingCompanyId);

    CarSharingCompany createCarSharingCompany(CarSharingCompanyDTO carSharingCompanyDTO);

    CarSharingCompany updateCarSharingCompany(CarSharingCompany carSharingCompany, CarSharingCompanyDTO carSharingCompanyDTO);

    void deleteCarSharingCompany(CarSharingCompany carSharingCompany);
}
