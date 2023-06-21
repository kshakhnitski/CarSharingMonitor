package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelResponse;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelUpdateRequest;

public interface CarModelServiceFacade {
    Iterable<CarModelResponse> getCarModels();

    CarModelResponse getCarModel(Long carModelId);

    CarModelResponse createCarModel(CarModelCreateRequest createRequest);

    CarModelResponse updateCarModel(Long carModelId, CarModelUpdateRequest updateRequest);

    void deleteCarModel(Long carModelId);
}
