package com.kshakhnitski.carsharingmonitor.facade.impl;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerDTO;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.ManufacturerServiceFacade;
import com.kshakhnitski.carsharingmonitor.mapper.ManufacturerMapper;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import com.kshakhnitski.carsharingmonitor.service.ManufacturerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ManufacturerServiceFacadeImpl implements ManufacturerServiceFacade {
    private final ManufacturerService manufacturerService;
    private final ManufacturerMapper mapper;

    @Override
    public Page<ManufacturerResponse> getManufacturers(Pageable pageable) {
        Page<Manufacturer> manufacturers = manufacturerService.getManufacturers(pageable);
        return mapper.toResponse(manufacturers);
    }

    @Override
    public ManufacturerResponse getManufacturer(Long manufacturerId) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        return mapper.toResponse(manufacturer);
    }

    @Override
    public ManufacturerResponse createManufacturer(ManufacturerCreateRequest manufacturerCreateRequest) {
        ManufacturerDTO manufacturerDTO = mapper.toDTO(manufacturerCreateRequest);
        Manufacturer manufacturer = manufacturerService.createManufacturer(manufacturerDTO);
        return mapper.toResponse(manufacturer);
    }

    @Override
    public ManufacturerResponse updateManufacturer(Long manufacturerId, ManufacturerUpdateRequest manufacturerUpdateRequest) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        ManufacturerDTO manufacturerDTO = mapper.toDTO(manufacturerUpdateRequest);
        manufacturer = manufacturerService.updateManufacturer(manufacturer, manufacturerDTO);
        return mapper.toResponse(manufacturer);
    }

    @Override
    public void deleteManufacturer(Long manufacturerId) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        manufacturerService.deleteManufacturer(manufacturer);
    }
}
