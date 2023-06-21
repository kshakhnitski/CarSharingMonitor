package com.kshakhnitski.carsharingmonitor.repo;

import com.kshakhnitski.carsharingmonitor.model.CarSharingCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSharingCompanyRepo extends CrudRepository<CarSharingCompany, Long> {
}
