package com.tumadre.dao.repository;

import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerVehicleRepository extends JpaRepository<OwnerVehicle, Long> {

    @Query(value = "SELECT  owner_id as ownerId, firstname, lastname, vehicle_id as vehicleId, brand, plate, color " +
            "FROM owner_vehicle " +
            "WHERE lastname=:lastname order by plate", nativeQuery = true)
    List<OwnerVehicleDto> findByLastname(@Param("lastname") String lastname);

    @Query(value = "SELECT  owner_id as ownerId, firstname, lastname, vehicle_id as vehicleId, brand, plate, color " +
            "FROM owner_vehicle order by plate", nativeQuery = true)
    List<OwnerVehicleDto> getAllOwnerVehicle();
}
