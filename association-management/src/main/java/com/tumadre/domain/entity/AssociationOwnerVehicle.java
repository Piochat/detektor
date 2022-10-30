package com.tumadre.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "OwnerVehicleAssociation", columnNames = {"ownerId", "vehicleId"})
        }

)
public class AssociationOwnerVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long associationId;

    private Long ownerId;
    private Long vehicleId;
}
