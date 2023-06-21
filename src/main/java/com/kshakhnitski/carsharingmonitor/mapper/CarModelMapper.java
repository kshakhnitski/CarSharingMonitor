package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.carmodel.*;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(uses = {ManufacturerMapper.class})
public interface CarModelMapper {
    CarModelPreviewResponse toPreviewResponse(CarModel carModel);

    CarModelResponse toResponse(CarModel carModel);

    default Page<CarModelResponse> toResponse(Page<CarModel> carModels) {
        return carModels.map(this::toResponse);
    }

    @Mapping(target = "model", source = "createRequest.model")
    CarModelDTO toDTO(CarModelCreateRequest createRequest, Manufacturer manufacturer);

    @Mapping(target = "model", source = "updateRequest.model")
    CarModelDTO toDTO(CarModelUpdateRequest updateRequest, Manufacturer manufacturer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registeredCars", ignore = true)
    CarModel toEntity(CarModelDTO carModelDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registeredCars", ignore = true)
    @Mapping(target = "model", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "manufacturer", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "seats", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "fuelType", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "transmissionType", nullValuePropertyMappingStrategy = IGNORE)
    void update(@MappingTarget CarModel carModel, CarModelDTO carModelDTO);
}
