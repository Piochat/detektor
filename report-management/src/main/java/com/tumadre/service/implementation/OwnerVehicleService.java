package com.tumadre.service.implementation;

import com.tumadre.dao.interfaces.OwnerVehicleDaoInte;
import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;
import com.tumadre.service.interfaces.OwnerVehicleServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerVehicleService implements OwnerVehicleServiceInte {

    @Autowired
    private OwnerVehicleDaoInte ownerVehicleDao;

    @Override
    public List<OwnerVehicleDto> getAll() {
        return ownerVehicleDao.get();
    }

    @Override
    public List<OwnerVehicleDto> getByName(String lastname) {
        return ownerVehicleDao.getByName(lastname);
    }
}
