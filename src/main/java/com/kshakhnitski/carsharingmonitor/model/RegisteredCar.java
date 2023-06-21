package com.kshakhnitski.carsharingmonitor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "registered_cars")
@Getter
@Setter
@NoArgsConstructor
public class RegisteredCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "license_plate_number", length = 30, nullable = false)
    private String licensePlateNumber;

    @ManyToOne
    @JoinColumn(name = "car_sharing_company_id", nullable = false)
    private CarSharingCompany carSharingCompany;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModel carModel;

    @Column(name = "price_per_minute", precision = 8, scale = 2, nullable = false)
    private BigDecimal pricePerMinute;

    @Embedded
    private CarLocation location;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RegisteredCar that = (RegisteredCar) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
