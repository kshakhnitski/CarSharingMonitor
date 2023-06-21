package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerUpdateRequest;

public interface ManufacturerServiceFacade {
    Iterable<ManufacturerResponse> getManufacturers();

    ManufacturerResponse getManufacturer(Long manufacturerId);

    ManufacturerResponse createManufacturer(ManufacturerCreateRequest manufacturerCreateRequest);

    ManufacturerResponse updateManufacturer(Long manufacturerId, ManufacturerUpdateRequest manufacturerUpdateRequest);

    void deleteManufacturer(Long manufacturerId);
}
