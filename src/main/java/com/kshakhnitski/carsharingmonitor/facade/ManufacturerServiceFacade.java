package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturerServiceFacade {
    Page<ManufacturerResponse> getManufacturers(Pageable pageable);

    ManufacturerResponse getManufacturer(Long manufacturerId);

    ManufacturerResponse createManufacturer(ManufacturerCreateRequest manufacturerCreateRequest);

    ManufacturerResponse updateManufacturer(Long manufacturerId, ManufacturerUpdateRequest manufacturerUpdateRequest);

    void deleteManufacturer(Long manufacturerId);
}
