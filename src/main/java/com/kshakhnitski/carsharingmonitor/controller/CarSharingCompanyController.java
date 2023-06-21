package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyResponse;
import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.CarSharingCompanyUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarSharingCompanyServiceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-sharing-companies")
@RequiredArgsConstructor
public class CarSharingCompanyController {
    private final CarSharingCompanyServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CarSharingCompanyResponse> getCarSharingCompanies() {
        return facade.getCarSharingCompanies();
    }

    @GetMapping(value = "/{carSharingCompanyId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CarSharingCompanyResponse getCarSharingCompany(@PathVariable Long carSharingCompanyId) {
        return facade.getCarSharingCompany(carSharingCompanyId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CarSharingCompanyResponse createCarSharingCompany(@Valid @RequestBody CarSharingCompanyCreateRequest createRequest) {
        return facade.createCarSharingCompany(createRequest);
    }

    @PatchMapping(value = "/{carSharingCompanyId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarSharingCompanyResponse updateCarSharingCompany(@PathVariable Long carSharingCompanyId,
                                                             @Valid @RequestBody CarSharingCompanyUpdateRequest updateRequest) {
        return facade.updateCarSharingCompany(carSharingCompanyId, updateRequest);
    }

    @DeleteMapping("/{carSharingCompanyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarSharingCompany(@PathVariable Long carSharingCompanyId) {
        facade.deleteCarSharingCompany(carSharingCompanyId);
    }
}
