package com.tumadre.controller;

import com.tumadre.domain.entity.Owner;
import com.tumadre.domain.model.OwnerModel;
import com.tumadre.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
@CrossOrigin
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<Owner>> get() {
        return ResponseEntity.ok(ownerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> get(@PathVariable long id) {
        var o = ownerService.get(id);
        if (o == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(o);
    }

    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody OwnerModel model) {
        var o = ownerService.save(model);
        if (o == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.status(HttpStatus.CREATED).body(o);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable long id, @RequestBody OwnerModel model) {
        var o = ownerService.update(model, id);
        if (o == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        return ResponseEntity.ok(ownerService.delete(id));
    }
}
