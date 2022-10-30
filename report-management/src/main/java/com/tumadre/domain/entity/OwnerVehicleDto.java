package com.tumadre.domain.entity;

import javax.persistence.Column;

public interface OwnerVehicleDto {
    public String getColor();
    @Column(name = "owner_id")
    public Long getOwnerId();
    @Column(name = "vehicle_id")
    public Long getVehicleId();
    public String getFirstname();
    public String getLastname();
    public String getPlate();
    public String getBrand();
}
