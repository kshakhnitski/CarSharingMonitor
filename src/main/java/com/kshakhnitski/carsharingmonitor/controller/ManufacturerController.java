package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.ManufacturerServiceFacade;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PageableAsQueryParam
    public Page<ManufacturerResponse> getManufacturers(@Parameter(hidden = true) Pageable pageable) {
        return facade.getManufacturers(pageable);
    }

    @GetMapping(value = "/{manufacturerId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ManufacturerResponse getManufacturer(@PathVariable Long manufacturerId) {
        return facade.getManufacturer(manufacturerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ManufacturerResponse createManufacturer(@Valid @RequestBody ManufacturerCreateRequest manufacturerCreateRequest) {
        return facade.createManufacturer(manufacturerCreateRequest);
    }

    @PatchMapping(value = "/{manufacturerId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManufacturerResponse updateManufacturer(@PathVariable Long manufacturerId,
                                                   @Valid @RequestBody ManufacturerUpdateRequest manufacturerUpdateRequest) {
        return facade.updateManufacturer(manufacturerId, manufacturerUpdateRequest);
    }

    @DeleteMapping("/{manufacturerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManufacturer(@PathVariable Long manufacturerId) {
        facade.deleteManufacturer(manufacturerId);
    }

}
