package com.tumadre.controller;

import com.tumadre.domain.entity.AssociationOwnerVehicle;
import com.tumadre.service.interfaces.AssociationVehicleOwnerServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associations")
@CrossOrigin
public class AssociationVehicleOwnerController {

    @Autowired
    private AssociationVehicleOwnerServiceInte service;

    @PostMapping
    public ResponseEntity<AssociationOwnerVehicle> create(@RequestBody AssociationOwnerVehicle associationOwnerVehicle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(associationOwnerVehicle));
    }

    @GetMapping("/{vehicleId}/with/{ownerId}")
    public ResponseEntity<AssociationOwnerVehicle> check(@PathVariable long vehicleId, @PathVariable long ownerId) {
        var o = service.get(vehicleId, ownerId);
        if (o == null) {
            return ResponseEntity.ok(o);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(o);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<AssociationOwnerVehicle>> check(@PathVariable long vehicleId) {
        var o = service.getVehicle(vehicleId);
        if (o.isEmpty())
            return ResponseEntity.ok(o);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(o);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<AssociationOwnerVehicle>> checkOwner(@PathVariable long ownerId) {
        var o = service.getOwner(ownerId);
        if (o.isEmpty())
            return ResponseEntity.ok(o);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(o);
    }
}
