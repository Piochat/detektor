package com.tumadre.dao.interfaces;

import com.tumadre.domain.entity.AssociationOwnerVehicle;

import java.util.List;
import java.util.Optional;

public interface AssociationVehicleOwnerDaoInte {

    public Optional<AssociationOwnerVehicle> get(long vehicleId, long ownerId);

    public AssociationOwnerVehicle save(AssociationOwnerVehicle associationOwnerVehicle);

    public List<AssociationOwnerVehicle> getVehicle(long vehicleId);

    public List<AssociationOwnerVehicle> getOwner(long ownerId);
}
