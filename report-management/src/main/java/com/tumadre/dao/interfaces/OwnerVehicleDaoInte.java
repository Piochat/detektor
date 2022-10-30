package com.tumadre.dao.interfaces;

import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;

import java.util.List;

public interface OwnerVehicleDaoInte {

    List<OwnerVehicleDto> get();

    List<OwnerVehicleDto> getByName(String lastname);
}
