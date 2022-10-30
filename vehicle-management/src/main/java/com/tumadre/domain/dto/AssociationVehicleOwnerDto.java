package com.tumadre.domain.dto;

import lombok.Data;

@Data
public class AssociationVehicleOwnerDto {
    private Long associationId;
    private Long ownerId;
    private Long vehicleId;
}
