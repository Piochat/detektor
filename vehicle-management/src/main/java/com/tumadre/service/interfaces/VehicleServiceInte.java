package com.tumadre.service.interfaces;

import com.tumadre.domain.entities.Vehicle;
import com.tumadre.domain.models.VehicleModel;

import java.util.List;

public interface VehicleServiceInte {

    public List<Vehicle> getAll();

    public Vehicle getVehicle(long id);

    public Vehicle save(VehicleModel vehicle);

    public Vehicle update(VehicleModel vehicle, long id);

    public Boolean delete(long id);
}
