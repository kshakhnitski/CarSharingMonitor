package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerDTO;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturerService {
    Page<Manufacturer> getManufacturers(Pageable pageable);

    Manufacturer getManufacturerById(Long manufacturerId);

    Manufacturer createManufacturer(ManufacturerDTO manufacturerDto);

    Manufacturer updateManufacturer(Manufacturer manufacturer, ManufacturerDTO manufacturerDto);

    void deleteManufacturer(Manufacturer manufacturer);
}
