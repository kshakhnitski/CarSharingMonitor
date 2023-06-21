package com.kshakhnitski.carsharingmonitor.service.impl;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.CarModelDTO;
import com.kshakhnitski.carsharingmonitor.exception.NotFoundException;
import com.kshakhnitski.carsharingmonitor.mapper.CarModelMapper;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.repo.CarModelRepo;
import com.kshakhnitski.carsharingmonitor.service.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {
    private final CarModelRepo carModelRepo;
    private final CarModelMapper mapper;

    @Override
    public Page<CarModel> getCarModels(Pageable pageable) {
        return carModelRepo.findAll(pageable);
    }

    @Override
    public CarModel getCarModelById(Long carModelId) {
        return carModelRepo.findById(carModelId)
                .orElseThrow(() -> new NotFoundException("Car model with ID " + carModelId + " not found"));
    }

    @Override
    public CarModel createCarModel(CarModelDTO carModelDTO) {
        CarModel carModel = mapper.toEntity(carModelDTO);
        return carModelRepo.save(carModel);
    }

    @Override
    public CarModel updateCarModel(CarModel carModel, CarModelDTO carModelDTO) {
        mapper.update(carModel, carModelDTO);
        return carModelRepo.save(carModel);
    }

    @Override
    public void deleteCarModel(CarModel carModel) {
        carModelRepo.delete(carModel);
    }
}
