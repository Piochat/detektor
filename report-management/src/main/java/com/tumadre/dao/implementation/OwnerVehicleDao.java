package com.tumadre.dao.implementation;

import com.tumadre.dao.interfaces.OwnerVehicleDaoInte;
import com.tumadre.dao.repository.OwnerVehicleRepository;
import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerVehicleDao implements OwnerVehicleDaoInte {

    @Autowired
    private OwnerVehicleRepository repository;

    @Override
    public List<OwnerVehicleDto> get() {
        //return repository.findAll(Sort.by(Sort.Direction.ASC, "plate"));
        return repository.getAllOwnerVehicle();
    }

    @Override
    public List<OwnerVehicleDto> getByName(String lastname) {
        return repository.findByLastname(lastname);
    }
}
