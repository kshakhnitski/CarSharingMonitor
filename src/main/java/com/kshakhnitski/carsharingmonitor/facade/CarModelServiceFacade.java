package com.kshakhnitski.carsharingmonitor.facade;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelResponse;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarModelServiceFacade {
    Page<CarModelResponse> getCarModels(Pageable pageable);

    CarModelResponse getCarModel(Long carModelId);

    CarModelResponse createCarModel(CarModelCreateRequest createRequest);

    CarModelResponse updateCarModel(Long carModelId, CarModelUpdateRequest updateRequest);

    void deleteCarModel(Long carModelId);
}
