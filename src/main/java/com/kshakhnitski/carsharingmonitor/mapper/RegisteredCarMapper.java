package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.registeredcar.CarRegistrationRequest;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarDTO;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarResponse;
import com.kshakhnitski.carsharingmonitor.dto.registeredcar.RegisteredCarUpdateRequest;
import com.kshakhnitski.carsharingmonitor.model.CarModel;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        uses = {CarModelMapper.class, CarSharingCompanyMapper.class}
)
public interface RegisteredCarMapper {
    RegisteredCarResponse toResponse(RegisteredCar registeredCar);

    default Page<RegisteredCarResponse> toResponse(Page<RegisteredCar> registeredCars) {
        return registeredCars.map(this::toResponse);
    }

    RegisteredCarDTO toDTO(CarRegistrationRequest registrationRequest, CarSharingCompany carSharingCompany, CarModel carModel);

    RegisteredCarDTO toDTO(RegisteredCarUpdateRequest updateRequest, CarSharingCompany carSharingCompany, CarModel carModel);

    @Mapping(target = "id", ignore = true)
    RegisteredCar toEntity(RegisteredCarDTO registeredCarDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "licensePlateNumber", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "carSharingCompany", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "carModel", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "pricePerMinute", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "location", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "isAvailable", nullValuePropertyMappingStrategy = IGNORE)
    void update(@MappingTarget RegisteredCar registeredCar, RegisteredCarDTO registeredCarDTO);
}
