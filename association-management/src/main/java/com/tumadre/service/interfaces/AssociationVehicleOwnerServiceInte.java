package com.tumadre.service.interfaces;

import com.tumadre.domain.entity.AssociationOwnerVehicle;

import java.util.List;

public interface AssociationVehicleOwnerServiceInte {

    AssociationOwnerVehicle get(long vehicleId, long ownerId);

    AssociationOwnerVehicle save(AssociationOwnerVehicle associationOwnerVehicle);

    List<AssociationOwnerVehicle> getOwner(long ownerId);

    List<AssociationOwnerVehicle> getVehicle(long vehicleId);

    void delete(long associationId);
}
