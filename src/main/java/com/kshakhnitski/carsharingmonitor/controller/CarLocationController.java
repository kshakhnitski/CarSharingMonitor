package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarLocationServiceFacade;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registered-cars/{registeredCarId}/location")
@RequiredArgsConstructor
public class CarLocationController {
    private final CarLocationServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CarLocation getCarLocation(@PathVariable Long registeredCarId) {
        return facade.getCarLocation(registeredCarId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarLocation updateCarLocation(@PathVariable Long registeredCarId,
                                         @Valid @RequestBody CarLocationUpdateRequest updateRequest) {
        return facade.updateCarLocation(registeredCarId, updateRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCarLocation(@PathVariable Long registeredCarId) {
        facade.clearCarLocation(registeredCarId);
    }
}
