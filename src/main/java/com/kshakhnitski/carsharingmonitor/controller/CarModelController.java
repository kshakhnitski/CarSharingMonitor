package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelResponse;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarModelServiceFacade;
import com.kshakhnitski.carsharingmonitor.model.FuelType;
import com.kshakhnitski.carsharingmonitor.model.TransmissionType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-models")
@RequiredArgsConstructor
public class CarModelController {
    private final CarModelServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CarModelResponse> getCarModels() {
        return facade.getCarModels();
    }

    @GetMapping(value = "/{carModelId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CarModelResponse getCarModel(@PathVariable Long carModelId) {
        return facade.getCarModel(carModelId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CarModelResponse createCarModel(@Valid @RequestBody CarModelCreateRequest createRequest) {
        return facade.createCarModel(createRequest);
    }

    @PatchMapping(value = "/{carModelId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarModelResponse updateCarModel(@PathVariable Long carModelId,
                                           @Valid @RequestBody CarModelUpdateRequest updateRequest) {
        return facade.updateCarModel(carModelId, updateRequest);
    }

    @DeleteMapping("/{carModelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarModel(@PathVariable Long carModelId) {
        facade.deleteCarModel(carModelId);
    }

    @GetMapping(value = "/transmission-types",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TransmissionType[] getTransmissionTypes() {
        return TransmissionType.values();
    }

    @GetMapping(value = "/fuel-types",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FuelType[] getFuelTypes() {
        return FuelType.values();
    }
}
