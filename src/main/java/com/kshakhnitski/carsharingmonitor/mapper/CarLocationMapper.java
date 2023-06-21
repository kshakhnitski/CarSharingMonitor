package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationUpdateRequest;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import org.mapstruct.Mapper;

@Mapper
public interface CarLocationMapper {
    CarLocation toEmbeddable(CarLocationUpdateRequest updateRequest);
}
