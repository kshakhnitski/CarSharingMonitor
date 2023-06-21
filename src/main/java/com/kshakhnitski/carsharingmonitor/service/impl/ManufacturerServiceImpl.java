package com.kshakhnitski.carsharingmonitor.service.impl;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerDTO;
import com.kshakhnitski.carsharingmonitor.exception.NotFoundException;
import com.kshakhnitski.carsharingmonitor.mapper.ManufacturerMapper;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import com.kshakhnitski.carsharingmonitor.repo.ManufacturerRepo;
import com.kshakhnitski.carsharingmonitor.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepo manufacturerRepo;
    private final ManufacturerMapper mapper;

    @Override
    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepo.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(Long manufacturerId) {
        return manufacturerRepo.findById(manufacturerId)
                .orElseThrow(() -> new NotFoundException("Manufacturer with ID " + manufacturerId + " not found"));
    }

    @Override
    public Manufacturer createManufacturer(ManufacturerDTO manufacturerDto) {
        Manufacturer manufacturer = mapper.toEntity(manufacturerDto);
        return manufacturerRepo.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer, ManufacturerDTO manufacturerDTO) {
        mapper.update(manufacturer, manufacturerDTO);
        return manufacturerRepo.save(manufacturer);
    }

    @Override
    public void deleteManufacturer(Manufacturer manufacturer) {
        manufacturerRepo.delete(manufacturer);
    }
}
