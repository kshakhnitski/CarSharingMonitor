package com.kshakhnitski.carsharingmonitor.mapper;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationRequest;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import org.mapstruct.Mapper;

@Mapper
public interface CarLocationMapper {
    CarLocation toEmbeddable(CarLocationRequest updateRequest);
}
