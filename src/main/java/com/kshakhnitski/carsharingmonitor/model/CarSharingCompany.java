package com.kshakhnitski.carsharingmonitor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "car_sharing_companies")
@Getter
@Setter
@NoArgsConstructor
public class CarSharingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "support_phones",
            joinColumns = @JoinColumn(name = "car_sharing_company_id", nullable = false)
    )
    @Column(name = "support_phone", length = 30, nullable = false)
    private List<String> supportPhones;

    @OneToMany(mappedBy = "carSharingCompany")
    private List<RegisteredCar> registeredCars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarSharingCompany that = (CarSharingCompany) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, address, supportPhones);
    }
}
