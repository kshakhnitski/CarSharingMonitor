package com.kshakhnitski.carsharingmonitor.repo;

import com.kshakhnitski.carsharingmonitor.model.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepo extends CrudRepository<CarModel, Long> {
}
