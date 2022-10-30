package com.tumadre.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModel {

    private String plate;
    private String vin;
    private String brand;
    private String line;
    private String cylinderCapacity;
    private String color;
    private String chassis;
    private VehicleType vehicleType;
    private String model;
}
