package com.tumadre.service.implementation;

import com.tumadre.dao.interfaces.VehicleDaoInte;
import com.tumadre.domain.dto.AssociationVehicleOwnerDto;
import com.tumadre.domain.entities.Vehicle;
import com.tumadre.domain.models.VehicleModel;
import com.tumadre.service.interfaces.VehicleServiceInte;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleServiceInte {

    @Autowired
    private VehicleDaoInte vehicleDao;

    @Autowired
    RestTemplate restTemplate;
    String associationURL = "http://ASSOCIATION-MANAGEMENT/api/v1/associations/vehicle/";

    @Override
    public List<Vehicle> getAll() {
        return vehicleDao.get();
    }

    @Override
    public Vehicle getVehicle(long id) {
        var v = vehicleDao.getById(id);

        if (v.isEmpty())
            return null;

        return v.get();
    }

    //TODO: Validar que no pertenezca a otro cliente
    @Override
    public Vehicle save(VehicleModel vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public Vehicle update(VehicleModel vehicle, long id) {
        return vehicleDao.update(vehicle, id);
    }

    @Override
    public Boolean delete(long id) {
        ResponseEntity<AssociationVehicleOwnerDto[]> response = restTemplate.getForEntity(associationURL + id, AssociationVehicleOwnerDto[].class);
        if (response.getStatusCode() == HttpStatus.ACCEPTED)
          return false;

        return vehicleDao.delete(id);
    }
}
