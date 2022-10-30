package com.tumadre.service.implementation;

import com.tumadre.dao.interfaces.AssociationVehicleOwnerDaoInte;
import com.tumadre.domain.entity.AssociationOwnerVehicle;
import com.tumadre.service.interfaces.AssociationVehicleOwnerServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationVehicleOwnerService implements AssociationVehicleOwnerServiceInte {

    @Autowired
    private AssociationVehicleOwnerDaoInte associationVehicleOwnerDao;

    @Override
    public AssociationOwnerVehicle get(long vehicleId, long ownerId) {
        var v = associationVehicleOwnerDao.get(vehicleId, ownerId);
        return v.orElse(null);
    }

    @Override
    public AssociationOwnerVehicle save(AssociationOwnerVehicle associationOwnerVehicle) {
        return associationVehicleOwnerDao.save(associationOwnerVehicle);
    }

    @Override
    public List<AssociationOwnerVehicle> getOwner(long ownerId) {
        return associationVehicleOwnerDao.getOwner(ownerId);
    }

    @Override
    public List<AssociationOwnerVehicle> getVehicle(long vehicleId) {
        return associationVehicleOwnerDao.getVehicle(vehicleId);
    }

    @Override
    public void delete(long associationId) {
        associationVehicleOwnerDao.delete(associationId);
    }
}
