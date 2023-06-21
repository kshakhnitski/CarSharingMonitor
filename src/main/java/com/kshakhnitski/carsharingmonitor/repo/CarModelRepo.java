package com.kshakhnitski.carsharingmonitor.repo;

import com.kshakhnitski.carsharingmonitor.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepo extends JpaRepository<CarModel, Long> {
}
