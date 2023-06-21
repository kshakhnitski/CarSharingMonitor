package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerDTO;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;

public interface ManufacturerService {
    Iterable<Manufacturer> getManufacturers();

    Manufacturer getManufacturerById(Long manufacturerId);

    Manufacturer createManufacturer(ManufacturerDTO manufacturerDto);

    Manufacturer updateManufacturer(Manufacturer manufacturer, ManufacturerDTO manufacturerDto);

    void deleteManufacturer(Manufacturer manufacturer);
}
