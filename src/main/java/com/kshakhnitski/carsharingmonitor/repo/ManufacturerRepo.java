package com.kshakhnitski.carsharingmonitor.repo;

import com.kshakhnitski.carsharingmonitor.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
