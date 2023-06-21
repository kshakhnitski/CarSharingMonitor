package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyDTO;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;

public interface CarSharingCompanyService {
    Iterable<CarSharingCompany> getCarSharingCompanies();

    CarSharingCompany getCarSharingCompanyById(Long carSharingCompanyId);

    CarSharingCompany createCarSharingCompany(CarSharingCompanyDTO carSharingCompanyDTO);

    CarSharingCompany updateCarSharingCompany(CarSharingCompany carSharingCompany, CarSharingCompanyDTO carSharingCompanyDTO);

    void deleteCarSharingCompany(CarSharingCompany carSharingCompany);
}
