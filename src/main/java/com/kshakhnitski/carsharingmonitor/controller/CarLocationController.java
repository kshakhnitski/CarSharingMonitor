package com.kshakhnitski.carsharingmonitor.controller;

import com.kshakhnitski.carsharingmonitor.dto.carlocation.CarLocationRequest;
import com.kshakhnitski.carsharingmonitor.facade.CarLocationServiceFacade;
import com.kshakhnitski.carsharingmonitor.model.CarLocation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registered-cars/{registeredCarId}/location")
@RequiredArgsConstructor
public class CarLocationController {
    private final CarLocationServiceFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content()),
    })
    public ResponseEntity<CarLocation> getCarLocation(@PathVariable Long registeredCarId) {
        CarLocation location = facade.getCarLocation(registeredCarId);
        HttpStatus status = (location == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(location, status);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarLocation updateCarLocation(@PathVariable Long registeredCarId,
                                         @Valid @RequestBody CarLocationRequest updateRequest) {
        return facade.updateCarLocation(registeredCarId, updateRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCarLocation(@PathVariable Long registeredCarId) {
        facade.clearCarLocation(registeredCarId);
    }
}
