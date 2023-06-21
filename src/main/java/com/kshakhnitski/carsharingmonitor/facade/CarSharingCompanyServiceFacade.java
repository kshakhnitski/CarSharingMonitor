package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyResponse;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarSharingCompanyServiceFacade {
    Page<CarSharingCompanyResponse> getCarSharingCompanies(Pageable pageable);

    CarSharingCompanyResponse getCarSharingCompany(Long carSharingCompanyId);

    CarSharingCompanyResponse createCarSharingCompany(CarSharingCompanyCreateRequest createRequest);

    CarSharingCompanyResponse updateCarSharingCompany(Long carSharingCompanyId, CarSharingCompanyUpdateRequest updateRequest);

    void deleteCarSharingCompany(Long carSharingCompanyId);
}
