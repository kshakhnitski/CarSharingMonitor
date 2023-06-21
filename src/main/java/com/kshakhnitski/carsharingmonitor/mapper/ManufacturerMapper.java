package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerCreateRequest;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerDTO;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerResponse;
import com.kshakhnitski.carsharingmonitor.dto.manufactuer.ManufacturerUpdateRequest;
import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

@Mapper
public interface ManufacturerMapper {

    ManufacturerResponse toResponse(Manufacturer manufacturer);

    default Page<ManufacturerResponse> toResponse(Page<Manufacturer> manufacturers) {
        return manufacturers.map(this::toResponse);
    }

    ManufacturerDTO toDTO(ManufacturerCreateRequest createRequest);

    ManufacturerDTO toDTO(ManufacturerUpdateRequest updateRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModels", ignore = true)
    Manufacturer toEntity(ManufacturerDTO manufacturerDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModels", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Manufacturer manufacturer, ManufacturerDTO manufacturerDTO);
}
