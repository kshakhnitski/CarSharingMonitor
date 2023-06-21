package com.kshakhnitski.carsharingmonitor.repo;

import com.kshakhnitski.carsharingmonitor.model.RegisteredCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredCarRepo extends JpaRepository<RegisteredCar, Long> {
}