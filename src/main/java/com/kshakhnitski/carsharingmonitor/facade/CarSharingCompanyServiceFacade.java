package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyResponse;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyUpdateRequest;

public interface CarSharingCompanyServiceFacade {
    Iterable<CarSharingCompanyResponse> getCarSharingCompanies();

    CarSharingCompanyResponse getCarSharingCompany(Long carSharingCompanyId);

    CarSharingCompanyResponse createCarSharingCompany(CarSharingCompanyCreateRequest createRequest);

    CarSharingCompanyResponse updateCarSharingCompany(Long carSharingCompanyId, CarSharingCompanyUpdateRequest updateRequest);

    void deleteCarSharingCompany(Long carSharingCompanyId);
}
