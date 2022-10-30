package com.tumadre.domain.entities;

import com.tumadre.domain.models.VehicleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String plate;
    @Column(unique = true)
    private String vin;
    private String brand;
    private String line;
    private String cylinderCapacity;
    private String color;
    private String chassis;
    private VehicleType vehicleType;
    private String model;
    private Boolean erased;
}
