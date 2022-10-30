package com.tumadre.domain.entity;


import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class OwnerVehicle {

    @Id
    private long id;
    private Long ownerId;
    private Long vehicleId;
    private String firstname;
    private String lastname;
    private String plate;
    private String brand;
    private String color;
}
