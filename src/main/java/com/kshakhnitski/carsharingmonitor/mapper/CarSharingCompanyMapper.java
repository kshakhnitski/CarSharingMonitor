package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.carsharingcompany.*;
import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface CarSharingCompanyMapper {
    CarSharingCompanyPreviewResponse toPreviewResponse(CarSharingCompany carSharingCompany);

    CarSharingCompanyResponse toResponse(CarSharingCompany carSharingCompany);

    Iterable<CarSharingCompanyResponse> toResponse(Iterable<CarSharingCompany> carSharingCompanies);

    CarSharingCompanyDTO toDTO(CarSharingCompanyCreateRequest createRequest);

    CarSharingCompanyDTO toDTO(CarSharingCompanyUpdateRequest updateRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registeredCars", ignore = true)
    CarSharingCompany toEntity(CarSharingCompanyDTO carSharingCompanyDTO);

    @Mapping(target = "registeredCars", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "description", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "address", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "supportPhones", nullValuePropertyMappingStrategy = IGNORE)
    void update(@MappingTarget CarSharingCompany carSharingCompany, CarSharingCompanyDTO carSharingCompanyDTO);
}
