package com.tumadre.controller;

import com.tumadre.domain.entities.Vehicle;
import com.tumadre.domain.models.VehicleModel;
import com.tumadre.service.interfaces.VehicleServiceInte;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin
@Slf4j
public class VehicleController {

    @Autowired
    private VehicleServiceInte vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> vehicles() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> vehicle(@PathVariable long id) {
        var v = vehicleService.getVehicle(id);
        if (v == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(v);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleModel vehicleModel) {
        var v = vehicleService.save(vehicleModel);
        if (v == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable long id, @RequestBody VehicleModel vehicleModel) {
        var v = vehicleService.update(vehicleModel, id);
        if (v == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(v);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable long id) {
        return ResponseEntity.ok(vehicleService.delete(id));
    }
}
