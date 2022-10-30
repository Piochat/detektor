package com.tumadre.dao.repository;

import com.tumadre.domain.entity.AssociationOwnerVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationVehicleOwnerRepository extends JpaRepository<AssociationOwnerVehicle, Long> {

    @Query("SELECT u FROM AssociationOwnerVehicle u WHERE vehicleId=?1 and ownerId=?2")
    Optional<AssociationOwnerVehicle> findByVehicleIdAndOwnerId(long vehicleId, long ownerId);

    List<AssociationOwnerVehicle> findByVehicleId(long vehicleId);

    List<AssociationOwnerVehicle> findByOwnerId(long ownerId);
}
