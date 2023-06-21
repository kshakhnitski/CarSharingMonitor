package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelDTO;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarModelService {
    Page<CarModel> getCarModels(Pageable pageable);

    CarModel getCarModelById(Long carModelId);

    CarModel createCarModel(CarModelDTO carModelDTO);

    CarModel updateCarModel(CarModel carModel, CarModelDTO carModelDTO);

    void deleteCarModel(CarModel carModel);
}
