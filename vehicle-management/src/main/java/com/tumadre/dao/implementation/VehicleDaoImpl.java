package com.tumadre.dao.implementation;

import com.tumadre.dao.interfaces.VehicleDaoInte;
import com.tumadre.dao.repository.VehicleRepository;
import com.tumadre.domain.entities.Vehicle;
import com.tumadre.domain.models.VehicleModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VehicleDaoImpl implements VehicleDaoInte {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> getById(long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> get() {
        return vehicleRepository.findByErasedFalse();
    }

    @Override
    public Vehicle save(VehicleModel vehicle) {
        Vehicle data = null;
        try {
           var v = Vehicle.builder()
                    .brand(vehicle.getBrand())
                    .line(vehicle.getLine())
                    .model(vehicle.getModel())
                    .plate(vehicle.getPlate())
                    .vin(vehicle.getVin())
                    .color(vehicle.getColor())
                    .chassis(vehicle.getChassis())
                    .vehicleType(vehicle.getVehicleType())
                    .cylinderCapacity(vehicle.getCylinderCapacity())
                    .erased(false)
                    .build();
           data = vehicleRepository.save(v);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return data;
    }

    @Override
    public Boolean delete(long id) {
        var v = getById(id);
        if (v.isEmpty())
            return false;

        var vehicle = v.get();
        vehicle.setErased(true);
        vehicleRepository.save(vehicle);
        return vehicle.getErased();
    }

    @Override
    public Vehicle update(VehicleModel vehicle, long id) {
        Vehicle v = null;
        try {
            var value = Vehicle.builder()
                    .vehicleId(id)
                    .brand(vehicle.getBrand())
                    .line(vehicle.getLine())
                    .model(vehicle.getModel())
                    .plate(vehicle.getPlate())
                    .vin(vehicle.getVin())
                    .color(vehicle.getColor())
                    .chassis(vehicle.getChassis())
                    .vehicleType(vehicle.getVehicleType())
                    .cylinderCapacity(vehicle.getCylinderCapacity())
                    .erased(false)
                    .build();
            v = vehicleRepository.save(value);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return v;
    }
}
