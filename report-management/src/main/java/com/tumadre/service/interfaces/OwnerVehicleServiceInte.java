package com.tumadre.service.interfaces;

import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;

import java.util.List;

public interface OwnerVehicleServiceInte {

    List<OwnerVehicleDto> getAll();

    List<OwnerVehicleDto> getByName(String lastname);
}
