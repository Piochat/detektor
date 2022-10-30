package com.tumadre.dao.interfaces;

import com.tumadre.domain.entities.Vehicle;
import com.tumadre.domain.models.VehicleModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface VehicleDaoInte {

    public Optional<Vehicle> getById(long id);

    public List<Vehicle> get();

    public Vehicle save(VehicleModel vehicle);

    public Boolean delete(long id);

    public Vehicle update(VehicleModel vehicle, long id);
}
