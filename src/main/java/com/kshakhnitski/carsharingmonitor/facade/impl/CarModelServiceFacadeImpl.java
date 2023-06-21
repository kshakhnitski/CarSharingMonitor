package com.kshakhnitski.carsharingmonitor.facade.impl;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelDTO;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelResponse;
import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelUpdateRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarModelServiceFacade;
import com.kshakhnitski.carsharingmonitor.mapper.CarModelMapper;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import com.kshakhnitski.carsharingmonitor.service.CarModelService;
import com.kshakhnitski.carsharingmonitor.service.ManufacturerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CarModelServiceFacadeImpl implements CarModelServiceFacade {
    private final CarModelService carModelService;
    private final ManufacturerService manufacturerService;
    private final CarModelMapper mapper;

    @Override
    public Iterable<CarModelResponse> getCarModels() {
        Iterable<CarModel> carModels = carModelService.getCarModels();
        return mapper.toResponse(carModels);
    }

    @Override
    public CarModelResponse getCarModel(Long carModelId) {
        CarModel carModel = carModelService.getCarModelById(carModelId);
        return mapper.toResponse(carModel);
    }

    @Override
    public CarModelResponse createCarModel(CarModelCreateRequest createRequest) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(createRequest.getManufacturerId());
        CarModelDTO carModelDTO = mapper.toDTO(createRequest, manufacturer);
        CarModel carModel = carModelService.createCarModel(carModelDTO);
        return mapper.toResponse(carModel);
    }

    @Override
    public CarModelResponse updateCarModel(Long carModelId, CarModelUpdateRequest updateRequest) {
        CarModel carModel = carModelService.getCarModelById(carModelId);

        Manufacturer manufacturer = (updateRequest.getManufacturerId() == null) ? null :
                manufacturerService.getManufacturerById(updateRequest.getManufacturerId());
        CarModelDTO carModelDTO = mapper.toDTO(updateRequest, manufacturer);

        carModel = carModelService.updateCarModel(carModel, carModelDTO);

        return mapper.toResponse(carModel);
    }

    @Override
    public void deleteCarModel(Long carModelId) {
        CarModel carModel = carModelService.getCarModelById(carModelId);
        carModelService.deleteCarModel(carModel);
    }
}
