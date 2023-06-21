package com.kshakhnitski.carsharingmonitor.service;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelDTO;
import com.kshakhnitski.carsharingmonitor.model.CarModel;

public interface CarModelService {
    Iterable<CarModel> getCarModels();

    CarModel getCarModelById(Long carModelId);

    CarModel createCarModel(CarModelDTO carModelDTO);

    CarModel updateCarModel(CarModel carModel, CarModelDTO carModelDTO);

    void deleteCarModel(CarModel carModel);
}
