package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.CarRegistrationRequest;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarResponse;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.RegisteredCarServiceFacade;
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
@RequestMapping("/api/v1/registered-cars")
@RequiredArgsConstructor
public class RegisteredCarController {
    private final RegisteredCarServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PageableAsQueryParam
    public Page<RegisteredCarResponse> getRegisteredCars(@Parameter(hidden = true) Pageable pageable) {
        return facade.getRegisteredCars(pageable);
    }

    @GetMapping(value = "/{registeredCarId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisteredCarResponse getRegisteredCar(@PathVariable Long registeredCarId) {
        return facade.getRegisteredCar(registeredCarId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredCarResponse registerCar(@Valid @RequestBody CarRegistrationRequest registrationRequest) {
        return facade.registerCar(registrationRequest);
    }

    @PatchMapping(value = "/{registeredCarId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisteredCarResponse updateRegisteredCar(@PathVariable Long registeredCarId,
                                                     @Valid @RequestBody RegisteredCarUpdateRequest updateRequest) {
        return facade.updateRegisteredCar(registeredCarId, updateRequest);
    }

    @DeleteMapping("/{registeredCarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegisteredCar(@PathVariable Long registeredCarId) {
        facade.deleteRegisteredCar(registeredCarId);
    }
}
