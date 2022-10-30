package com.tumadre.controller;

import com.tumadre.domain.entity.OwnerVehicle;
import com.tumadre.domain.entity.OwnerVehicleDto;
import com.tumadre.service.interfaces.OwnerVehicleServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner-vehicle")
@CrossOrigin
public class OwnerVehicleController {

    @Autowired
    private OwnerVehicleServiceInte ownerVehicleService;

    @GetMapping
    public ResponseEntity<List<OwnerVehicleDto>> get() {
        return ResponseEntity.ok(ownerVehicleService.getAll());
    }

    @GetMapping("/{lastname}")
    public ResponseEntity<List<OwnerVehicleDto>> get(@PathVariable String lastname) {
        return ResponseEntity.ok(ownerVehicleService.getByName(lastname));
    }
}
