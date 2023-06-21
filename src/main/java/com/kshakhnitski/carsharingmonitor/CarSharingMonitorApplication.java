package com.kshakhnitski.carsharingmonitor;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class CarSharingMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSharingMonitorApplication.class, args);
    }

    @PostConstruct
    private static void setTimeZoneUTC() {
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        log.info("Setting the timezone " + utcTimeZone.getID());
        TimeZone.setDefault(utcTimeZone);
    }
}
