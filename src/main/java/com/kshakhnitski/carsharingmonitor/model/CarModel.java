package com.kshakhnitski.carsharingmonitor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "car_models")
@Getter
@Setter
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model", length = 50, nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", length = 20, nullable = false)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission_type", length = 20, nullable = false)
    private TransmissionType transmissionType;

    @OneToMany(mappedBy = "carModel")
    private List<RegisteredCar> registeredCars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarModel carModel = (CarModel) o;
        return getId() != null && Objects.equals(getId(), carModel.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
