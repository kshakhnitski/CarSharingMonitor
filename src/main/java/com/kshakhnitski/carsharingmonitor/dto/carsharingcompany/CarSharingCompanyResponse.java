package com.kshakhnitski.carsharingmonitor.dto.carsharingcompany;

import lombok.Data;

import java.util.List;

@Data
public class CarSharingCompanyResponse {
    private Long id;
    private String name;
    private String description;
    private String address;
    private List<String> supportPhones;
}
