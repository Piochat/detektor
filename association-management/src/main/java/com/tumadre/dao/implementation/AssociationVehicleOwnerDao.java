package com.tumadre.dao.implementation;

import com.tumadre.dao.interfaces.AssociationVehicleOwnerDaoInte;
import com.tumadre.dao.repository.AssociationVehicleOwnerRepository;
import com.tumadre.domain.entity.AssociationOwnerVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationVehicleOwnerDao implements AssociationVehicleOwnerDaoInte {

    @Autowired
    private AssociationVehicleOwnerRepository repository;

    @Override
    public Optional<AssociationOwnerVehicle> get(long vehicleId, long ownerId) {
        return repository.findByVehicleIdAndOwnerId(vehicleId, ownerId);
    }

    @Override
    public AssociationOwnerVehicle save(AssociationOwnerVehicle associationOwnerVehicle) {
        return repository.save(associationOwnerVehicle);
    }

    @Override
    public List<AssociationOwnerVehicle> getVehicle(long vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }

    @Override
    public List<AssociationOwnerVehicle> getOwner(long ownerId) {
        return repository.findByOwnerId(ownerId);
    }
}
